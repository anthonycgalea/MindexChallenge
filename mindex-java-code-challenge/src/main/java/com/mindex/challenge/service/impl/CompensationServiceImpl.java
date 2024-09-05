package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.CompensationRequest;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Implementation of the {@link CompensationService}.
 *
 * @author Anthony Galea
 */
@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private final CompensationRepository compensationRepository;

    @Autowired
    private final EmployeeService employeeService;

    /**
     * Constructor for dependency injection.
     *
     * @param compensationRepository {@link CompensationRepository}
     */
    public CompensationServiceImpl(CompensationRepository compensationRepository,
                                   EmployeeService employeeService) {
        this.compensationRepository = compensationRepository;
        this.employeeService = employeeService;
    }


    /**
     * Method to add compensation data to the database.
     *
     * @param compensationRequest The {@link CompensationRequest} to convert into a {@link Compensation}
     * @return Returns the completed {@link Compensation data}
     */
    @Override
    public Compensation addCompensation(CompensationRequest compensationRequest) {
        LOG.debug("Creating compensation record [{}]", compensationRequest);

        Compensation newCompensation = new Compensation();
        newCompensation.setEffectiveDate(compensationRequest.getEffectiveDate());
        newCompensation.setSalary(compensationRequest.getSalary());
        newCompensation.setEmployee(this.employeeService.read(compensationRequest.getEmployeeId()));
        return compensationRepository.insert(newCompensation);
    }

    /**
     * Method to retrieve all compensation data associated with an employeeId.
     *
     * @param employeeId The employeeId to retrieve with
     * @return Returns all associated {@link Compensation}
     */
    @Override
    public List<Compensation> getCompensationData(String employeeId) {
        LOG.debug("Retrieving compensation records with employee id {}", employeeId);
        if (!StringUtils.isEmpty(employeeId)) {
            Employee employee = employeeService.read(employeeId);
            return compensationRepository.findCompensationByEmployee(employee);
        }
        throw new RuntimeException(String.format("No compensation records found for employeeId %s", employeeId));
    }
}
