package com.skoolio.PaymentService.PaymentService.controllers;

import com.skoolio.PaymentService.PaymentService.entities.Payment;
import com.skoolio.PaymentService.PaymentService.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    @PostMapping
    public ResponseEntity<?> createAPayment(@RequestBody Payment payment){
        try {
            Payment payment1 = paymentService.createPayment(payment);
            HashMap hashMap = new HashMap<String,String>();
            hashMap.put("status", "Payment created. Id - "+payment1.getPaymentId());
            return ResponseEntity.status(HttpStatus.OK).body(hashMap);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
