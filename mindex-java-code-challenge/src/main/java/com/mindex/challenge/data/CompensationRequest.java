package com.mindex.challenge.data;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 * Java object representing a Compensation request.
 *
 * @author Anthony Galea
 */
public class CompensationRequest {
    String employeeId;
    BigInteger salary;
    LocalDate effectiveDate;

    /**
     * Getter for employeeId.
     *
     * @return Returns the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Getter for salary.
     *
     * @return Returns the salary
     */
    public BigInteger getSalary() {
        return salary;
    }

    /**
     * Getter for the effectiveDate.
     *
     * @return Returns the effectiveDate
     */
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Setter for employeeId.
     *
     * @param employeeId The new employeeId
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Setter for Salary.
     *
     * @param salary The new salary
     */
    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    /**
     * Setter for effectiveDate
     *
     * @param effectiveDate The new effectiveDate
     */
    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
