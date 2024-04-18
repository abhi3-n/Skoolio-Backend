package com.skoolio.PaymentService.PaymentService.repositories;

import com.skoolio.PaymentService.PaymentService.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,String> {
    List<Payment> findByStudentIdAndStatus(String studentId, String status);


    @Transactional
    @Modifying
    @Query(value = "UPDATE payment p SET p.paid_amount = :paidAmount, p.payment_date = :paymentDate, p.status = :status WHERE p.student_id = :studentId AND p.payment_id = :paymentId", nativeQuery = true)
    void updatePaymentDetails(String studentId, String paymentId, Integer paidAmount, Long paymentDate, String status);
}
