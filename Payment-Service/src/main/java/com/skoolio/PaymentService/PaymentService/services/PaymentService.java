package com.skoolio.PaymentService.PaymentService.services;

import com.skoolio.PaymentService.PaymentService.entities.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment) throws Exception;

    List<Payment> getFeesListForStudent(String studentId, String status);
}
