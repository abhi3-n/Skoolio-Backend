package com.skoolio.PaymentService.PaymentService.controllers;


import com.skoolio.PaymentService.PaymentService.entities.Payment;
import com.skoolio.PaymentService.PaymentService.services.PaymentService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/payments")
public class PaymentsController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{studentId}/{status}")
    public ResponseEntity<?> getFeesListForStudent(@PathVariable String studentId, @PathVariable String status){
        try {
            List<Payment> paymentsList = paymentService.getFeesListForStudent(studentId, status);
            return ResponseEntity.status(HttpStatus.SC_OK).body(paymentsList);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{schoolId}/{studentId}/{status}")
    public ResponseEntity<?> getFeesListForStudent(@PathVariable String schoolId,@PathVariable String studentId, @PathVariable String status){
        //TODO: First we need to verify if the student velongs to this school or not. If not, we won't send details to requestor
        System.out.println(schoolId);
        try {
            List<Payment> paymentsList = paymentService.getFeesListForStudent(studentId, status);
            return ResponseEntity.status(HttpStatus.SC_OK).body(paymentsList);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
