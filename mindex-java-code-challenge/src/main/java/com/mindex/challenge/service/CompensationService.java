package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.CompensationRequest;

import java.util.List;

/**
 * Interface for reading of {@link Compensation} data.
 *
 * @author Anthony Galea
 */
public interface CompensationService {
    Compensation addCompensation(CompensationRequest compensationRequest);
    List<Compensation> getCompensationData(String employeeId);
}
