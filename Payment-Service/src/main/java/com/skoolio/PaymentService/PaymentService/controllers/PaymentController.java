package com.skoolio.PaymentService.PaymentService.controllers;

import com.skoolio.PaymentService.PaymentService.entities.Payment;
import com.skoolio.PaymentService.PaymentService.model.PaymentUpdateRequest;
import com.skoolio.PaymentService.PaymentService.services.PaymentService;
import com.skoolio.PaymentService.PaymentService.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/info")
    public ResponseEntity<?> getPaymentPageRelatedData(){
        HashMap data = new HashMap<String,String>();
        data.put("apiKey", Constants.keyId);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @PatchMapping
    public ResponseEntity<?> updatePaymentRequest(@RequestBody PaymentUpdateRequest paymentUpdateRequest){
        try{
            System.out.println(paymentUpdateRequest.toString());
            paymentService.updatePaymentRequest(paymentUpdateRequest);
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
