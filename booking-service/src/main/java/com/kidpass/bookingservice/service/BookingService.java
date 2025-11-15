package com.kidpass.bookingservice.service;

import com.kidpass.bookingservice.entity.Booking;
import com.kidpass.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        // Additional logic like checking activity availability can be added here
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(String id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getBookingsByUserId(String userId) {
        return bookingRepository.findByUserId(userId);
    }

    public Booking updateBookingStatus(String id, String status) {
        Booking existingBooking = bookingRepository.findById(id).orElse(null);
        if (existingBooking != null) {
            existingBooking.setStatus(status);
            return bookingRepository.save(existingBooking);
        }
        return null;
    }
}
