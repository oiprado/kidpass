package com.kidpass.bookingservice.repository;

import com.kidpass.bookingservice.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {

    List<Booking> findByUserId(String userId);
    List<Booking> findByActivityId(String activityId);
}
