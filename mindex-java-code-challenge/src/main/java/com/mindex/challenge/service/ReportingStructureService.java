package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;

/**
 * Interface for reading of ReportingStructure data.
 *
 * @author Anthony Galea
 */
public interface ReportingStructureService {
    ReportingStructure getReportingStructure(String employeeId);
}
