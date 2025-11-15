package com.kidpass.reportingservice.service;

import lombok.Data;

import java.util.Date;

@Data
public class AuthorizationTimeSeriesReport {
    private Date date;
    private int count;
}
