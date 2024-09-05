package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Implementation of the {@link ReportingStructureService}.
 *
 * @author Anthony Galea
 */
@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Constructor for dependency injection
     */
    public ReportingStructureServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Implemented method to retrieve a {@link ReportingStructure} for a given employeeId.
     *
     * @param employeeId String containing the requested employeeId
     * @return Returns a {@link ReportingStructure} with the requested information
     */
    @Override
    public ReportingStructure getReportingStructure(String employeeId) {
        if (!StringUtils.isEmpty(employeeId)) {
            final Employee employee = this.employeeService.read(employeeId); //validation of valid Employee is already done by employeeService
            return new ReportingStructure(employee, employee.calculateNumberOfDirectReports());
        }

        throw new RuntimeException("EmployeeId must not be an empty String");
    }
}
