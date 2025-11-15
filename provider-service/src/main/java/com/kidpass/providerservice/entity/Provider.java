package com.kidpass.providerservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "providers")
@Data
public class Provider {

    @Id
    private String id;
    private String name;
    private String contactEmail;
    private String contactPhone;
    private String address;
    private String description;
    private List<String> activityIds; // IDs of activities offered by this provider
}
