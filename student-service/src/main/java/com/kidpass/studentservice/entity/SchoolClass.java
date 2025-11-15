package com.kidpass.studentservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "classes")
@Data
public class SchoolClass {

    @Id
    private String id;
    private String className;
    private String gradeLevel;
    private String teacherId;
}
