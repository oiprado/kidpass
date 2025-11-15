package com.kidpass.qrservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "qrcodes")
@Data
public class QRCode {

    @Id
    private String id;
    private String authorizationId; // Link to Authorization ID
    private String codeData; // The actual QR code data (e.g., a URL or unique string)
    private LocalDateTime generatedDate;
    private LocalDateTime expirationDate;
    private String status; // ACTIVE, USED, EXPIRED
}
