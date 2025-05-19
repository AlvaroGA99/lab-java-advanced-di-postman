package com.ironhack.lab_java_advanced_di_postman.config;

import com.ironhack.lab_java_advanced_di_postman.services.EarlyBirdDiscountService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@Configuration
public class DiscountFeatureConfig {

    @Bean
    @ConditionalOnProperty(name = "feature.discount.enabled", havingValue = "true")
    public EarlyBirdDiscountService discountFeature() {
        return new EarlyBirdDiscountService();
    }

    @Bean
    @ConditionalOnProperty(name = "feature.discount.enabled", havingValue = "false", matchIfMissing = true)
    public EarlyBirdDiscountService discountFeatureDisabled() {

        return new EarlyBirdDiscountService(){
            @Override
            public ResponseEntity<String> applyEarlyBirdDiscount(Date bookingDate, Date eventDate) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Discount feature is disabled. Please enable it int the application properties");
            }
        };
    }
}
