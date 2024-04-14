package com.skoolio.PaymentService.PaymentService.services;

import org.json.JSONObject;

public interface OrderService {
    JSONObject createOrder(Integer amount,
                           String studentId,
                           String classId,
                           String receipt,
                           Long feeMonthEpoch) throws Exception;
}
