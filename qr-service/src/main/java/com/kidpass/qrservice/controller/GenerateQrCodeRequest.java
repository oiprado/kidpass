package com.kidpass.qrservice.controller;

import lombok.Data;

@Data
public class GenerateQrCodeRequest {
    private String authorizationId;
}
