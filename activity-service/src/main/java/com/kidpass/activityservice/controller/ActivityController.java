package com.kidpass.activityservice.controller;

import com.kidpass.activityservice.entity.Activity;
import com.kidpass.activityservice.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> searchActivities(@RequestParam(required = false) String category,
                                           @RequestParam(required = false) String ageRange,
                                           @RequestParam(required = false) String location) {
        return activityService.searchActivities(category, ageRange, location);
    }

    @GetMapping("/{id}")
    public Activity getActivityById(@PathVariable String id) {
        return activityService.getActivityById(id);
    }

    @PostMapping
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }

    @PutMapping("/{id}")
    public Activity updateActivity(@PathVariable String id, @RequestBody Activity activity) {
        return activityService.updateActivity(id, activity);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable String id) {
        activityService.deleteActivity(id);
    }
}
