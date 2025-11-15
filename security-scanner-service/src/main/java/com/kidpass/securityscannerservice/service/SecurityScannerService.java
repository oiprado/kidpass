package com.kidpass.securityscannerservice.service;

import com.kidpass.securityscannerservice.entity.ScanEvent;
import com.kidpass.securityscannerservice.repository.ScanEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class SecurityScannerService {

    @Autowired
    private ScanEventRepository scanEventRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public ScanEvent validateQrCode(String qrCodeId, String scannerId, String securityPersonnelId) {
        // Call QR Service to validate the QR code
        // For simplicity, we'll assume the QR service is running on localhost:8090
        // In a real scenario, service discovery would be used.
        String qrServiceUrl = "http://qr-service:8090/qrcodes/validate/" + qrCodeId;
        Boolean isValid = restTemplate.postForObject(qrServiceUrl, null, Boolean.class);

        ScanEvent scanEvent = new ScanEvent();
        scanEvent.setQrCodeId(qrCodeId);
        scanEvent.setScannerId(scannerId);
        scanEvent.setSecurityPersonnelId(securityPersonnelId);
        scanEvent.setScanTimestamp(LocalDateTime.now());

        if (Boolean.TRUE.equals(isValid)) {
            scanEvent.setValidationStatus("VALID");
        } else {
            scanEvent.setValidationStatus("INVALID");
        }

        return scanEventRepository.save(scanEvent);
    }
}
