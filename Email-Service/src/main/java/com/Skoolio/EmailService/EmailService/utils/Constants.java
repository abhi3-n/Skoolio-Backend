package com.Skoolio.EmailService.EmailService.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Constants {
    private String registrationOTPSubject = "Email Verification";
    private String registrationOTPBody1 = "Dear User,\n" +
            "\n" +
            "Thank you for choosing Skoolio. To complete your registration and verify your email address, please use the following One-Time Password (OTP):\n";
    private String registrationOTPBody2 ="\nPlease note that this OTP is valid for a short period of time. Do not share this OTP with anyone for security reasons.\n" +
            "\n" +
            "If you did not request this OTP, please ignore this email.\n" +
            "\n" +
            "Thank you,\n"+
            "Skoolio.";
}
