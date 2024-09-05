package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link ReportingStructureServiceImpl}.
 *
 * @author Anthony Galea
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportingStructureServiceImplTest {

    @Mock
    private EmployeeService mockEmployeeService;

    private ReportingStructureServiceImpl reportingStructureService;

    /**
     * Setup dependency injection
     */
    @Before
    public void setup() {
        this.reportingStructureService = new ReportingStructureServiceImpl(this.mockEmployeeService);
    }

    /**
     * Test method to check whether when the employee service returns an employee with
     * three direct reports, it properly evaluates the amount of direct reports.
     */
    @Test
    public void getReportingStructure_twoLevelsOfReporting_returnsAsExpected() {
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("Ringo");
        testEmployee.setLastName("Starr");
        testEmployee.setDepartment("Engineering");
        testEmployee.setPosition("Developer V");
        testEmployee.setEmployeeId("03aa1462-ffa9-4978-901b-7c001562cf6f");

        Employee directReport1 = new Employee();
        directReport1.setFirstName("Pete");
        directReport1.setLastName("Best");
        directReport1.setPosition("Developer II");
        directReport1.setDepartment("Engineering");
        directReport1.setEmployeeId("62c1084e-6e34-4630-93fd-9153afb6530");
        Employee directReport2 = new Employee();
        directReport2.setFirstName("George");
        directReport2.setLastName("Harrison");
        directReport2.setPosition("Developer III");
        directReport2.setDepartment("Engineering");
        directReport2.setEmployeeId("c0c2293d-16bd-4603-8e08-638a9d18b22c");
        Employee directReport3 = new Employee();
        directReport3.setFirstName("Paul");
        directReport3.setLastName("McCartney");
        directReport3.setPosition("Developer I");
        directReport3.setDepartment("Engineering");
        directReport3.setEmployeeId("b7839309-3348-463b-a7e3-5de1c168beb3");
        directReport2.getDirectReports().add(directReport3);
        List<Employee> directReports = new ArrayList<>();
        directReports.add(directReport1);
        directReports.add(directReport2);
        testEmployee.setDirectReports(directReports);
        ReportingStructure expectedReportingStructure = new ReportingStructure(testEmployee, 3);
        when(this.mockEmployeeService.read(any())).thenReturn(testEmployee);

        //Check whether the ReportingStructure returns correctly
        ReportingStructure actualReportingStructure = this.reportingStructureService.getReportingStructure("03aa1462-ffa9-4978-901b-7c001562cf6f");
        assertNotNull(actualReportingStructure.getEmployee());
        assertEquals(actualReportingStructure.getEmployee().getEmployeeId(), expectedReportingStructure.getEmployee().getEmployeeId());
        assertEquals(expectedReportingStructure.getNumberOfReports(), actualReportingStructure.getNumberOfReports());
    }

    /**
     * Test to assert that when an invalid id format is given, an exception is thrown.
     */
    @Test
    public void getReportingStructure_blankInput_throwsRuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> this.reportingStructureService.getReportingStructure(""));
        Assertions.assertThrows(RuntimeException.class, () -> this.reportingStructureService.getReportingStructure(null));
    }
}
