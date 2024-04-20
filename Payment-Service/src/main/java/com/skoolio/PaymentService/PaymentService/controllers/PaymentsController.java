package com.skoolio.PaymentService.PaymentService.controllers;


import com.skoolio.PaymentService.PaymentService.entities.Payment;
import com.skoolio.PaymentService.PaymentService.model.CreatePaymentsObj;
import com.skoolio.PaymentService.PaymentService.services.PaymentService;
import jakarta.ws.rs.POST;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity<?> getFeeListForStudent(@PathVariable String schoolId,@PathVariable String studentId, @PathVariable String status){
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

    @GetMapping("/monthlyData/{monthEpoch}/{classId}")
    public ResponseEntity<?> getFeePaymentsForMonthAndClassId(@PathVariable String monthEpoch,@PathVariable String classId){
        try {
            List<Payment> paymentsList = paymentService.getFeePaymentsForMonthAndClassId(Long.parseLong(monthEpoch), classId);
            return ResponseEntity.status(HttpStatus.SC_OK).body(paymentsList);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("month")
    public ResponseEntity<?> createFeePaymentsForMonth(@RequestBody CreatePaymentsObj createPaymentsObj){
        try {
            paymentService.createFeePaymentsForMonth(createPaymentsObj);
            HashMap hashMap = new HashMap<String,String>();
            hashMap.put("status", "Created");
            return ResponseEntity.status(org.springframework.http.HttpStatus.OK).body(hashMap);
        }
        catch (Exception e){
            return ResponseEntity.status(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
