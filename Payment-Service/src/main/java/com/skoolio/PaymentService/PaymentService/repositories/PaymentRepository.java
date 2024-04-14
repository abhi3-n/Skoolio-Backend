package com.skoolio.PaymentService.PaymentService.repositories;

import com.skoolio.PaymentService.PaymentService.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,String> {
    List<Payment> findByStudentIdAndStatus(String studentId, String status);
}
