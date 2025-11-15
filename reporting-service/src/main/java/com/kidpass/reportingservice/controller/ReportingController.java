package com.kidpass.reportingservice.controller;

import com.kidpass.reportingservice.service.AuthorizationStatusReport;
import com.kidpass.reportingservice.service.AuthorizationTimeSeriesReport;
import com.kidpass.reportingservice.service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportingController {

    @Autowired
    private ReportingService reportingService;

    @GetMapping
    public List<ReportDto> getAllReports() {
        return Arrays.asList(
                new ReportDto("auth_status", "Authorization Status Report", "Authorization", "Report on the status of authorizations."),
                new ReportDto("auth_timeseries", "Authorization Time Series Report", "Authorization", "Time series data for authorizations.")
        );
    }

    @GetMapping("/authorizations/status")
    public List<AuthorizationStatusReport> getAuthorizationStatusReport() {
        return reportingService.getAuthorizationStatusReport();
    }

    @GetMapping("/authorizations/timeseries")
    public List<AuthorizationTimeSeriesReport> getAuthorizationTimeSeriesReport() {
        return reportingService.getAuthorizationTimeSeriesReport();
    }
}
