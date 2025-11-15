package com.kidpass.bookingservice.controller;

import com.kidpass.bookingservice.entity.Booking;
import com.kidpass.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable String id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable String userId) {
        return bookingService.getBookingsByUserId(userId);
    }

    @PutMapping("/{id}/status")
    public Booking updateBookingStatus(@PathVariable String id, @RequestParam String status) {
        return bookingService.updateBookingStatus(id, status);
    }
}
