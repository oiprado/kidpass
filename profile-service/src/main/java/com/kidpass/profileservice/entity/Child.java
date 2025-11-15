package com.kidpass.profileservice.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Child {

    private String name;
    private LocalDate dateOfBirth;
}
