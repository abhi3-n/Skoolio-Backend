package com.skoolio.PaymentService.PaymentService.implementations;

import com.skoolio.PaymentService.PaymentService.entities.Payment;
import com.skoolio.PaymentService.PaymentService.model.PaymentUpdateRequest;
import com.skoolio.PaymentService.PaymentService.repositories.PaymentRepository;
import com.skoolio.PaymentService.PaymentService.services.OrderService;
import com.skoolio.PaymentService.PaymentService.services.PaymentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderService orderService;
    @Override
    public Payment createPayment(Payment payment) throws Exception {
        try {
            payment.ready();
            JSONObject order = orderService.createOrder(payment.getFeeAmount(),
                    payment.getStudentId(),
                    payment.getClassId(),
                    payment.getPaymentId(),
                    payment.getFeeMonthEpoch());
            payment.setOrderId((String) order.get("id"));
            try {
                return paymentRepository.save(payment);
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Payment> getFeesListForStudent(String studentId, String status) {
        return paymentRepository.findByStudentIdAndStatus(studentId,status);
    }

    @Override
    public List<Payment> getFeePaymentsForMonthAndClassId(Long monthEpoch, String classId) {
        return paymentRepository.findByFeeMonthEpochAndClassId(monthEpoch, classId);
    }

    @Override
    public void updatePaymentRequest(PaymentUpdateRequest paymentUpdateRequest) {
        paymentRepository.updatePaymentDetails(paymentUpdateRequest.getStudentId(),
                paymentUpdateRequest.getPaymentId(),
                paymentUpdateRequest.getAmount(), paymentUpdateRequest.getPaymentDate(), "paid");
    }
}
/*
Order structure
{
    "id": "order_NyXPw2EIJeE8bf",
    "entity": "order",
    "amount": 100,
    "amount_paid": 0,
    "amount_due": 100,
    "currency": "INR",
    "receipt": "Receipt no. 1",
    "offer_id": null,
    "status": "created",
    "attempts": 0,
    "notes": {
        "notes_key_1": "Tea, Earl Grey, Hot",
        "notes_key_2": "Tea, Earl Grey… decaf."
    },
    "created_at": 1713105483
}
 */