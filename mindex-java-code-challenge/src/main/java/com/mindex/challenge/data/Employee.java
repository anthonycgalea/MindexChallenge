package com.mindex.challenge.data;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private List<Employee> directReports;

    public Employee() {
        this.directReports = new ArrayList<>();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(List<Employee> directReports) {
        this.directReports = directReports;
    }

    /**
     * Helper method to recursively collect the amount of direct reports for the given employee.
     *
     * @return Returns the number of direct reports for this Employee
     */
    public Integer calculateNumberOfDirectReports() {
        final List<Employee> directReports = getDirectReports();
        if (directReports == null) {
            return 0;
        }
        int numberOfDirectReports = directReports.size();
        for (Employee report : directReports) {
            numberOfDirectReports += report.calculateNumberOfDirectReports();
        }
        return numberOfDirectReports;
    }
}
