package com.Skoolio.EmailService.EmailService.controllers;

import com.Skoolio.EmailService.EmailService.models.EmailOtpRequest;
import com.Skoolio.EmailService.EmailService.models.EmailOtpResponse;
import com.Skoolio.EmailService.EmailService.services.EmailService;
import com.Skoolio.EmailService.EmailService.utils.Constants;
import com.Skoolio.EmailService.EmailService.utils.RandomOTPGenerator;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private Constants constants;

    @PostMapping()
    @Operation(summary = "This endpoint is used to send an OTP for mail verification.")
    public ResponseEntity<?> sendRegistrationOTPMail(@RequestBody EmailOtpRequest emailOtpRequest){
        int otp = RandomOTPGenerator.generateOTP();
        String message = constants.getRegistrationOTPBody1() + String.valueOf(otp) + constants.getRegistrationOTPBody2();
        boolean status =  this.emailService.sendEmail(constants.getRegistrationOTPSubject(),
                message,
                emailOtpRequest.getEmail());
        EmailOtpResponse emailOtpResponse = new EmailOtpResponse(String.valueOf(otp));

        if(status) {
            return ResponseEntity.status(HttpStatus.OK).body(emailOtpResponse);
        }else {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent.");
        }
    }



//    @Autowired
//    private KafkaService kafkaService;
//
//    @PostMapping("/send")
//    public ResponseEntity<?> sendMail(){
//        kafkaService.updateLocation("("+ Math.round(Math.random()*100) +", " + Math.round(Math.random()*100) +")");
//        System.out.println("Location produced.");
//        return new ResponseEntity(Map.of("message","location updated"),HttpStatus.OK);
//    }
}
