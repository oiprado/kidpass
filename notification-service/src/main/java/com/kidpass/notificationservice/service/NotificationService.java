package com.kidpass.notificationservice.service;

import com.kidpass.notificationservice.entity.Notification;
import com.kidpass.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.Bean;
import java.util.function.Consumer;

import org.springframework.messaging.simp.SimpMessagingTemplate;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Bean
    public Consumer<String> input() {
        return message -> {
            // For simplicity, we'll just log the message for now
            System.out.println("Received message: " + message);

            // Send a message to the WebSocket topic
            messagingTemplate.convertAndSend("/topic/notifications", message);

            // In a real scenario, you would create and send a notification here
            // For example:
            // Notification notification = new Notification();
            // notification.setUserId(...); // Extract user ID from message
            // notification.setMessage("A new authorization has been created.");
            // createNotification(notification);
            // sendNotification(notification);
        };
    }

    public Notification createNotification(Notification notification) {
        notification.setTimestamp(LocalDateTime.now());
        notification.setStatus("SENT");
        Notification savedNotification = notificationRepository.save(notification);
        messagingTemplate.convertAndSend("/topic/notifications", savedNotification);
        return savedNotification;
    }

    public List<Notification> getNotificationsByUserId(String userId) {
        return notificationRepository.findByUserId(userId);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Placeholder for actual sending logic (e.g., email, SMS, in-app)
    public void sendNotification(Notification notification) {
        // Implement actual sending logic here
        System.out.println("Sending notification to " + notification.getUserId() + ": " + notification.getMessage());
    }
}
