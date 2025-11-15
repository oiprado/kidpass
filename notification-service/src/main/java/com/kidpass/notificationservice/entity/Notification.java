package com.kidpass.notificationservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "notifications")
@Data
public class Notification {

    @Id
    private String id;
    private String userId;
    private String type; // e.g., EMAIL, SMS, IN_APP
    private String subject;
    private String message;
    private LocalDateTime timestamp;
    private String status; // e.g., SENT, FAILED, READ
}
