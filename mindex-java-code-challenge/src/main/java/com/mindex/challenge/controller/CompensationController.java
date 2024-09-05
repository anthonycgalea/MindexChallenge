package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.CompensationRequest;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for accessing and modifying {@link Compensation} data
 *
 * @author Anthony Galea
 */
@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    /**
     * POST method for adding compensation data.
     *
     * @param compensation The {@link Compensation} to add
     * @return Returns the newly created {@link Compensation} object
     */
    @PostMapping("/compensation")
    public Compensation addCompensationData(@RequestBody CompensationRequest compensation) {
        LOG.debug("Received compensation request for [{}]", compensation);

        return compensationService.addCompensation(compensation);
    }

    /**
     * GET method for retireving all compensation data associated with an employeeId.
     *
     * @param employeeId EmployeeId to retrieve with
     * @return Returns a {@link List<>} of {@link Compensation} data
     */
    @GetMapping("/compensation/{employeeId}")
    public List<Compensation> getCompensationData(@PathVariable String employeeId) {
        LOG.debug("Received request to retrieve all compensation data for employee id {}", employeeId);

        return compensationService.getCompensationData(employeeId);
    }
}
