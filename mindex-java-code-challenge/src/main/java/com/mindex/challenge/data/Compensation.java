package com.mindex.challenge.data;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 * Object to represent salary history for an Employee.
 *
 * @author Anthony Galea
 */
public class Compensation {
    Employee employee;
    BigInteger salary;
    LocalDate effectiveDate;

    /**
     * Getter for Employee property.
     * @return Returns the associated {@link Employee}
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Setter for Employee property.
     * @param employee The {@link Employee} to set the employee property to
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Getter for the Salary property.
     * @return Returns a BigInteger of the salary
     */
    public BigInteger getSalary() {
        return salary;
    }

    /**
     * Setter for the salary property.
     * @param salary The new salary
     */
    public void setSalary(BigInteger salary) {
        if (salary.compareTo(BigInteger.valueOf(0)) >= 0) { //if salary is greater than or equal to 0 (second 0 represents equal, not the comparison)
            this.salary = salary;
        }
    }

    /**
     * Getter for the effective date of the compensation.
     * @return Returns the effective date for the given compensation
     */
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Setter for the effectiveDate of the compensation.
     * @param effectiveDate The effectiveDate of the compensation
     */
    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
