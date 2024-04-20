package com.skoolio.PaymentService.PaymentService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentsObj {
    private Long feeMonthEpoch;
    private String classId;
    private Integer feeAmount;
    private List<String> listOfStudentId;
}
