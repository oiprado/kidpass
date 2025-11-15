package com.kidpass.profileservice.controller;

import com.kidpass.profileservice.entity.UserProfile;
import com.kidpass.profileservice.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/{userId}")
    public UserProfile getUserProfile(@PathVariable String userId) {
        return userProfileService.getUserProfileByUserId(userId);
    }

    @PostMapping
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.createUserProfile(userProfile);
    }

    @PutMapping("/{userId}")
    public UserProfile updateUserProfile(@PathVariable String userId, @RequestBody UserProfile userProfile) {
        return userProfileService.updateUserProfile(userId, userProfile);
    }
}
