package com.mindex.challenge.data;

/**
 * Object to represent the amount of reports under a given employee.
 *
 * @author Anthony Galea
 */
public class ReportingStructure {
    final Employee employee;
    final Integer numberOfReports;

    /**
     * Constructor for ReportingStructure that allows for a provided Employee and the given Employee's numberOfReports.
     *
     * @param employee The {@link Employee} corresponding to the given ReportingStructure
     * @param numberOfReports The number of reporting employees to the given Employee.
     */
    public ReportingStructure(Employee employee, Integer numberOfReports) {
        this.employee = employee;
        this.numberOfReports = numberOfReports;
    }

    /**
     * Getter method for Employee.
     *
     * @return The associated {@link Employee}
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Getter method for the number of reports associated with the associated Employee.
     *
     * @return The amount of direct reports
     */
    public Integer getNumberOfReports() {
        return numberOfReports;
    }
}
