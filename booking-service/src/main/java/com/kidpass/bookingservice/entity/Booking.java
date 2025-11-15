package com.kidpass.bookingservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "bookings")
@Data
public class Booking {

    @Id
    private String id;
    private String userId;
    private String activityId;
    private String scheduleId;
    private LocalDateTime bookingDate;
    private String status; // e.g., PENDING, CONFIRMED, CANCELLED
}
