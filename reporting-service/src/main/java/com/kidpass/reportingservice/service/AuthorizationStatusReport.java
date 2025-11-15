package com.kidpass.reportingservice.service;

import lombok.Data;

@Data
public class AuthorizationStatusReport {
    private String status;
    private int count;
}
