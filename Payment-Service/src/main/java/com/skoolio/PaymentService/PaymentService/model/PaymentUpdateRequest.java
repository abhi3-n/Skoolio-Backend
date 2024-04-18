package com.skoolio.PaymentService.PaymentService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentUpdateRequest {
    private String studentId;
    private String paymentId;
    private Integer amount;
    private Long paymentDate;

    @Override
    public String toString() {
        return "PaymentUpdateRequest{" +
                "studentId='" + studentId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
