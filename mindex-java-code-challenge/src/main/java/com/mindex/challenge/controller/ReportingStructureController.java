package com.mindex.challenge.controller;

import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mindex.challenge.data.ReportingStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for accessing {@link ReportingStructure} data.
 *
 * @author Anthony Galea
 */
@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private ReportingStructureService reportingStructureService;

    /**
     * GET endpoint for retrieving direct reports for a given employeeId.
     *
     * @param employeeId String that contains the id requested
     * @return Returns the requested id's {@link ReportingStructure}
     */
    @GetMapping("/reports/{employeeId}")
    public ReportingStructure getDirectReports(@PathVariable String employeeId) {
        LOG.debug("Received direct reports request for id [{}]", employeeId);

        return this.reportingStructureService.getReportingStructure(employeeId);
    }
}
