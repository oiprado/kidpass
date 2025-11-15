package com.kidpass.activityservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "activities")
@Data
public class Activity {

    @Id
    private String id;
    private String providerId;
    private String title;
    private String description;
    private String category;
    private String ageRange;
    private List<Schedule> schedule;
    private BigDecimal price;
    private String location;
}
