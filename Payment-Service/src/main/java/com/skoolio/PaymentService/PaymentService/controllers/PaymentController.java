package com.skoolio.PaymentService.PaymentService.controllers;

import com.skoolio.PaymentService.PaymentService.entities.Payment;
import com.skoolio.PaymentService.PaymentService.model.PaymentUpdateRequest;
import com.skoolio.PaymentService.PaymentService.services.PaymentService;
import com.skoolio.PaymentService.PaymentService.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "This endpoint is used to create a new fee entry.")
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
    @Operation(summary = "This endpoint is used to fetch payment page related info like RazorPay keyId.")
    public ResponseEntity<?> getPaymentPageRelatedData(){
        HashMap data = new HashMap<String,String>();
        data.put("apiKey", Constants.keyId);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @PatchMapping
    @Operation(summary = "This endpoint is used to update a fee payment details like status and paid amount.")
    public ResponseEntity<?> updatePaymentRequest(@RequestBody PaymentUpdateRequest paymentUpdateRequest){
        try{
            paymentService.updatePaymentRequest(paymentUpdateRequest);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
