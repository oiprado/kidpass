package com.kidpass.authorizationservice.controller;

import com.kidpass.authorizationservice.entity.Authorization;
import com.kidpass.authorizationservice.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authorizations")
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping
    public Authorization createAuthorization(@RequestBody Authorization authorization) {
        return authorizationService.createAuthorization(authorization);
    }

    @GetMapping
    public List<Authorization> getAllAuthorizations() {
        return authorizationService.getAllAuthorizations();
    }

    @GetMapping("/{id}")
    public Authorization getAuthorizationById(@PathVariable String id) {
        return authorizationService.getAuthorizationById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Authorization> getAuthorizationsByUserId(@PathVariable String userId) {
        return authorizationService.getAuthorizationsByUserId(userId);
    }

    @GetMapping("/student/{studentId}")
    public List<Authorization> getAuthorizationsByStudentId(@PathVariable String studentId) {
        return authorizationService.getAuthorizationsByStudentId(studentId);
    }

    @PutMapping("/{id}/status")
    public Authorization updateAuthorizationStatus(@PathVariable String id, @RequestParam String status, @RequestParam String approvedBy) {
        return authorizationService.updateAuthorizationStatus(id, status, approvedBy);
    }
}
