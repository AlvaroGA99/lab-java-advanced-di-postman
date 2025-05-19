package com.ironhack.lab_java_advanced_di_postman.services;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;


public class EarlyBirdDiscountService {

    public ResponseEntity<String> applyEarlyBirdDiscount(Date bookingDate, Date eventDate) {

        if(bookingDate == null || eventDate == null) {
            return ResponseEntity.badRequest().body("Invalid request. Please provide valid booking and event dates as request parameters.");
        }

        long difference = eventDate.getTime() - bookingDate.getTime();

        if(difference < 0) {
            return ResponseEntity.badRequest().body("Invalid request. Event date cannot be before booking date.");
        }

        long daysDifference = difference / (1000 * 60 * 60 * 24);

        if(daysDifference >= 30) {
            return ResponseEntity.ok().body("15% discount applied succesfully.");
        }else if (daysDifference < 30 && daysDifference >= 15) {
            return ResponseEntity.ok().body("10% discount applied succesfully.");
        }else if(daysDifference < 15 && daysDifference >= 10) {
            return ResponseEntity.ok().body("5% discount applied succesfully.");
        }else{
            return ResponseEntity.ok().body("No discount applied. Booking date is less than 10 days before the event date.");
        }

    }
}
