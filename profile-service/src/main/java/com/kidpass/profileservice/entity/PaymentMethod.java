package com.kidpass.profileservice.entity;

import lombok.Data;

@Data
public class PaymentMethod {

    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
}
