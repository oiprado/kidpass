package com.kidpass.activityservice.service;

import com.kidpass.activityservice.entity.Activity;
import com.kidpass.activityservice.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity getActivityById(String id) {
        return activityRepository.findById(id).orElse(null);
    }

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity updateActivity(String id, Activity activity) {
        Activity existingActivity = activityRepository.findById(id).orElse(null);
        if (existingActivity != null) {
            existingActivity.setTitle(activity.getTitle());
            existingActivity.setDescription(activity.getDescription());
            existingActivity.setCategory(activity.getCategory());
            existingActivity.setAgeRange(activity.getAgeRange());
            existingActivity.setSchedule(activity.getSchedule());
            existingActivity.setPrice(activity.getPrice());
            existingActivity.setLocation(activity.getLocation());
            return activityRepository.save(existingActivity);
        }
        return null;
    }

    public void deleteActivity(String id) {
        activityRepository.deleteById(id);
    }

    public List<Activity> searchActivities(String category, String ageRange, String location) {
        if (category != null) {
            return activityRepository.findByCategory(category);
        }
        if (ageRange != null) {
            return activityRepository.findByAgeRange(ageRange);
        }
        if (location != null) {
            return activityRepository.findByLocation(location);
        }
        return activityRepository.findAll();
    }
}
