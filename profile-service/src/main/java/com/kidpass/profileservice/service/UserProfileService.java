package com.kidpass.profileservice.service;

import com.kidpass.profileservice.entity.UserProfile;
import com.kidpass.profileservice.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile getUserProfileByUserId(String userId) {
        return userProfileRepository.findByUserId(userId).orElse(null);
    }

    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile updateUserProfile(String userId, UserProfile userProfile) {
        UserProfile existingProfile = userProfileRepository.findByUserId(userId).orElse(null);
        if (existingProfile != null) {
            existingProfile.setChildren(userProfile.getChildren());
            existingProfile.setPaymentMethods(userProfile.getPaymentMethods());
            return userProfileRepository.save(existingProfile);
        }
        return null;
    }
}
