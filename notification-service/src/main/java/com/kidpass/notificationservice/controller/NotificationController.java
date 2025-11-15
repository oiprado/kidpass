package com.kidpass.notificationservice.controller;

import com.kidpass.notificationservice.entity.Notification;
import com.kidpass.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public Notification createAndSendNotification(@RequestBody Notification notification) {
        Notification savedNotification = notificationService.createNotification(notification);
        notificationService.sendNotification(savedNotification);
        return savedNotification;
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getNotificationsByUserId(@PathVariable String userId) {
        return notificationService.getNotificationsByUserId(userId);
    }
}
