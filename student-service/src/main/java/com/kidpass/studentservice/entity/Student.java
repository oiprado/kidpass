package com.kidpass.studentservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "students")
@Data
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private List<String> guardianIds; // Link to User IDs
    private List<String> classIds;
    private List<String> enrolledActivityIds; // IDs of activities the student is enrolled in
}
