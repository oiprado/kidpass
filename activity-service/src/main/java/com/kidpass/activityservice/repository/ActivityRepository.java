package com.kidpass.activityservice.repository;

import com.kidpass.activityservice.entity.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityRepository extends MongoRepository<Activity, String> {

    List<Activity> findByCategory(String category);

    List<Activity> findByAgeRange(String ageRange);

    List<Activity> findByLocation(String location);
}
