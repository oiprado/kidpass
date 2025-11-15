package com.kidpass.authorizationservice.service;

import com.kidpass.authorizationservice.entity.Authorization;
import com.kidpass.authorizationservice.repository.AuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.cloud.stream.function.StreamBridge;

@Service
public class AuthorizationService {

    @Autowired
    private AuthorizationRepository authorizationRepository;

    @Autowired
    private StreamBridge streamBridge;

    public Authorization createAuthorization(Authorization authorization) {
        authorization.setRequestDate(LocalDateTime.now());
        authorization.setStatus("PENDING");
        Authorization savedAuthorization = authorizationRepository.save(authorization);

        // Send event to RabbitMQ
        streamBridge.send("output", MessageBuilder.withPayload(savedAuthorization).build());

        return savedAuthorization;
    }

    public Authorization getAuthorizationById(String id) {
        return authorizationRepository.findById(id).orElse(null);
    }

    public List<Authorization> getAllAuthorizations() {
        return authorizationRepository.findAll();
    }

    public List<Authorization> getAuthorizationsByUserId(String userId) {
        return authorizationRepository.findByUserId(userId);
    }

    public List<Authorization> getAuthorizationsByStudentId(String studentId) {
        return authorizationRepository.findByStudentId(studentId);
    }

    public Authorization updateAuthorizationStatus(String id, String status, String approvedBy) {
        Authorization existingAuthorization = authorizationRepository.findById(id).orElse(null);
        if (existingAuthorization != null) {
            existingAuthorization.setStatus(status);
            existingAuthorization.setApprovalDate(LocalDateTime.now());
            existingAuthorization.setApprovedBy(approvedBy);
            return authorizationRepository.save(existingAuthorization);
        }
        return null;
    }
}
