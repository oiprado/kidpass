package com.kidpass.activityservice.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Schedule {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
