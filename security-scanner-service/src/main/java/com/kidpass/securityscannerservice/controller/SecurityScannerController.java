package com.kidpass.securityscannerservice.controller;

import com.kidpass.securityscannerservice.entity.ScanEvent;
import com.kidpass.securityscannerservice.service.SecurityScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scans")
public class SecurityScannerController {

    @Autowired
    private SecurityScannerService securityScannerService;

    @PostMapping("/validate")
    public ResponseEntity<ScanEvent> validateQrCode(@RequestParam String qrCodeId,
                                                    @RequestParam String scannerId,
                                                    @RequestParam String securityPersonnelId) {
        ScanEvent scanEvent = securityScannerService.validateQrCode(qrCodeId, scannerId, securityPersonnelId);
        return ResponseEntity.ok(scanEvent);
    }
}
