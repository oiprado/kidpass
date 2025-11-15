package com.kidpass.securityscannerservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "scan-events")
@Data
public class ScanEvent {

    @Id
    private String id;
    private String qrCodeId;
    private String scannerId;
    private LocalDateTime scanTimestamp;
    private String validationStatus; // VALID, INVALID, EXPIRED
    private String securityPersonnelId;
}
