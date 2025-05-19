package com.ironhack.lab_java_advanced_di_postman.controllers;

import com.ironhack.lab_java_advanced_di_postman.services.EarlyBirdDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/discount")
@RequiredArgsConstructor
public class DiscountController {

    private final EarlyBirdDiscountService earlyBirdDiscountService;

    @GetMapping
    public ResponseEntity<String> getApplyDiscount(@RequestParam(name = "bookingDate", required =false) Date bookingDate,
                                                   @RequestParam(name = "eventDate", required = false) Date eventDate) {



        return earlyBirdDiscountService.applyEarlyBirdDiscount(bookingDate, eventDate);
    }
}
