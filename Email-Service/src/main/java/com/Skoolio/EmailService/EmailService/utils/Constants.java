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
    private String mailEnding = "Thank you,\n"+
            "Skoolio.";
    private String registrationOTPSubject = "Email Verification";
    private String registrationOTPBody1 = "Dear User,\n" +
            "\n" +
            "Thank you for choosing Skoolio. To complete your registration and verify your email address, please use the following One-Time Password (OTP):\n";
    private String registrationOTPBody2 ="\nPlease note that this OTP is valid for a short period of time. Do not share this OTP with anyone for security reasons.\n" +
            "\n" +
            "If you did not request this OTP, please ignore this email.\n" +
            "\n" +
            mailEnding;

    private String studentRegistrationSubject = "Registration Complete";
    private String studentRegistrationBody1 = "Dear User,\n"+
    "\n" +
    "Congratulations! We are thrilled to welcome you to Skoolio! Your registration was successful.\n\n" +
     "Application Id - ";
    private String studentRegistrationBody2 = "\n\nPlease keep this Application ID handy, as it will " +
            "be useful for any future communications or inquiries related to your application.\n\n"+
            "If you have any questions or need assistance, feel free to reach out for support at skoolioofficial@gmail.com.\n"+
            mailEnding;


    private String schoolStudentRegistrationSubject = "New Student Registration Notification \uD83D\uDCDA";
    private String schoolStudentRegistrationBody1 = "Dear School,\n"+
            "We hope this message finds you well. This is to inform you about a recent student registration on Skoolio." +
            " The application is currently pending approval.\n"+
            "Application ID - ";
    private String schoolStudentRegistrationBody2 = "\n\nAction Required:\n" +
            "You can review the details of the student application on the application by using the provided Application ID.\n"+
            "If you have any questions or concerns, please feel free to contact us at skoolioofficial@gmail.com.\n"+
            "Thank you for partnering with Skoolio. We look forward to continuing to work together to support students in their " +
            "educational journey.\n"+
            mailEnding;


}
