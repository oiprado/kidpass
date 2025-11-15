package com.kidpass.qrservice.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.kidpass.qrservice.entity.QRCode;
import com.kidpass.qrservice.repository.QRCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class QRCodeService {

    @Autowired
    private QRCodeRepository qrCodeRepository;

    public QRCode generateQRCode(String authorizationId, String data, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height, hints);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();

        String base64Image = Base64.getEncoder().encodeToString(pngData);

        QRCode qrCode = new QRCode();
        qrCode.setAuthorizationId(authorizationId);
        qrCode.setCodeData(base64Image); // Store Base64 encoded image
        qrCode.setGeneratedDate(LocalDateTime.now());
        qrCode.setExpirationDate(LocalDateTime.now().plusHours(1)); // Example: expires in 1 hour
        qrCode.setStatus("ACTIVE");

        return qrCodeRepository.save(qrCode);
    }

    public QRCode getQRCodeById(String id) {
        return qrCodeRepository.findById(id).orElse(null);
    }

    public boolean validateQRCode(String id) {
        QRCode qrCode = getQRCodeById(id);
        if (qrCode != null && qrCode.getStatus().equals("ACTIVE") && qrCode.getExpirationDate().isAfter(LocalDateTime.now())) {
            qrCode.setStatus("USED");
            qrCodeRepository.save(qrCode);
            return true;
        }
        return false;
    }
}
