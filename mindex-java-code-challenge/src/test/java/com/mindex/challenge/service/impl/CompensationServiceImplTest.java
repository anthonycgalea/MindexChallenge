package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.CompensationRequest;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link CompensationServiceImpl}.
 *
 * @author Anthony Galea
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompensationServiceImplTest {

    @Mock
    private EmployeeService mockEmployeeService;

    @Mock
    private CompensationRepository mockCompensationRepository;

    private CompensationServiceImpl compensationService;

    /**
     * Setup dependency injection
     */
    @Before
    public void setup() {
        this.compensationService = new CompensationServiceImpl(this.mockCompensationRepository, this.mockEmployeeService);
    }

    /**
     * Test case to test the expected valid case
     */
    @Test
    public void getCompensationData_validEmployeeId_returnsAsExpected() {
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("Ringo");
        testEmployee.setLastName("Starr");
        testEmployee.setDepartment("Engineering");
        testEmployee.setPosition("Developer V");
        testEmployee.setEmployeeId("03aa1462-ffa9-4978-901b-7c001562cf6f");

        Compensation expectedCompensation = new Compensation();
        expectedCompensation.setSalary(new BigInteger("100000"));
        expectedCompensation.setEffectiveDate(LocalDate.parse("2020-01-01"));
        expectedCompensation.setEmployee(testEmployee);
        List<Compensation> expectedResult = new ArrayList<>();
        expectedResult.add(expectedCompensation);
        when(this.mockCompensationRepository.findCompensationByEmployee(any())).thenReturn(expectedResult);
        List<Compensation> actualResult = this.compensationService.getCompensationData("03aa1462-ffa9-4978-901b-7c001562cf6f");

        assertEquals(1, actualResult.size());
        assertEquals(new BigInteger("100000"), actualResult.get(0).getSalary());
        assertEquals(LocalDate.parse("2020-01-01"), actualResult.get(0).getEffectiveDate());
        assertEquals("Ringo", actualResult.get(0).getEmployee().getFirstName());
    }

    /**
     * Test case to assert a blank id throws an exception
     */
    @Test
    public void getCompensationData_blankRequests_throwsRuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> this.compensationService.getCompensationData(""));
        Assertions.assertThrows(RuntimeException.class, () -> this.compensationService.getCompensationData(null));
    }

    /**
     * Method to test that the compensation service handles addCompensation properly.
     */
    @Test
    public void addCompensation_validEntryWithRequest_returnsCompensation() {
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("Ringo");
        testEmployee.setLastName("Starr");
        testEmployee.setDepartment("Engineering");
        testEmployee.setPosition("Developer V");
        testEmployee.setEmployeeId("03aa1462-ffa9-4978-901b-7c001562cf6f");

        Compensation expectedCompensation = new Compensation();
        expectedCompensation.setSalary(new BigInteger("100000"));
        expectedCompensation.setEffectiveDate(LocalDate.parse("2020-01-01"));
        expectedCompensation.setEmployee(testEmployee);

        CompensationRequest compensationRequest = new CompensationRequest();
        compensationRequest.setSalary(new BigInteger("100000"));
        compensationRequest.setEffectiveDate(LocalDate.parse("2020-01-01"));
        compensationRequest.setEmployeeId("03aa1462-ffa9-4978-901b-7c001562cf6f");

        when(this.mockCompensationRepository.insert((Compensation) any())).thenReturn(expectedCompensation);
        Compensation actualCompensation = this.compensationService.addCompensation(compensationRequest);

        assertEquals(expectedCompensation.getSalary(), actualCompensation.getSalary());
        assertEquals(expectedCompensation.getEffectiveDate(), actualCompensation.getEffectiveDate());
        assertEquals(expectedCompensation.getEmployee().getEmployeeId(), actualCompensation.getEmployee().getEmployeeId());
    }


}
