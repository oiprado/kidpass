package com.kidpass.reportingservice.controller;

import lombok.Data;

@Data
public class ReportDto {
    private String id;
    private String name;
    private String type;
    private String description;

    public ReportDto(String id, String name, String type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }
}
