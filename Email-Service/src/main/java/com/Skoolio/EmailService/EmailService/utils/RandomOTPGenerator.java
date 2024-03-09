package com.Skoolio.EmailService.EmailService.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomOTPGenerator {
    public static int generateOTP() {
        // Specify the range for the 6-digit OTP
        int minRange = 100000;
        int maxRange = 999999;

        // Generate a random number within the specified range
        Random random = new Random();
        return random.nextInt((maxRange - minRange) + 1) + minRange;
    }
}
