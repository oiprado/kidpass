package com.kidpass.qrservice.controller;

import com.google.zxing.WriterException;
import com.kidpass.qrservice.entity.QRCode;
import com.kidpass.qrservice.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/qrcodes")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping("/generate")
    public ResponseEntity<QRCode> generateQRCode(@RequestBody GenerateQrCodeRequest request) {
        try {
            QRCode qrCode = qrCodeService.generateQRCode(request.getAuthorizationId(), request.getAuthorizationId(), 200, 200);
            return new ResponseEntity<>(qrCode, HttpStatus.CREATED);
        } catch (WriterException | IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<QRCode> getQRCode(@PathVariable String id) {
        QRCode qrCode = qrCodeService.getQRCodeById(id);
        if (qrCode != null) {
            return new ResponseEntity<>(qrCode, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/validate/{id}")
    public ResponseEntity<Boolean> validateQRCode(@PathVariable String id) {
        boolean isValid = qrCodeService.validateQRCode(id);
        return new ResponseEntity<>(isValid, HttpStatus.OK);
    }
}
