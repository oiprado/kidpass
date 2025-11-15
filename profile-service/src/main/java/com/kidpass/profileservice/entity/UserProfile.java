package com.kidpass.profileservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user-profiles")
@Data
public class UserProfile {

    @Id
    private String id;
    private String userId;
    private List<Child> children;
    private List<PaymentMethod> paymentMethods;
}
