package com.kidpass.authorizationservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "authorizations")
@Data
public class Authorization {

    @Id
    private String id;
    private String userId;
    private String studentId;
    private String activityId; // For event authorization
    private String type; // EVENT_PARTICIPATION, SCHOOL_EXIT
    private String status; // PENDING, APPROVED, REJECTED, EXPIRED
    private LocalDateTime requestDate;
    private LocalDateTime approvalDate;
    private String approvedBy;
    private String qrCodeId; // For school exit
}
