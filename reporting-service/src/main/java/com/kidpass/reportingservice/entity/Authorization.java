package com.kidpass.reportingservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "authorizations") // Match the collection name in authorization-service
@Data
public class Authorization {

    @Id
    private String id;
    private String userId;
    private String studentId;
    private String activityId;
    private String type;
    private String status;
    private LocalDateTime requestDate;
    private LocalDateTime approvalDate;
    private String approvedBy;
    private String qrCodeId;
}
