package com.skoolio.PaymentService.PaymentService.entities;


import com.skoolio.PaymentService.PaymentService.utils.UniqueIdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    private String paymentId;
    @Column(nullable = false)
    private String studentId;
    @Column(nullable = false)
    private String classId;

    @Column(nullable = false)
    private Long feeMonthEpoch; //Epoch value of first day of month
    private Integer feeAmount;

    @Column(nullable = false)
    private String status;
    private Integer paidAmount;
    private Long paymentDate;

    @Column(nullable = false)
    private String orderId;

    public void ready() {
        this.paymentId = UniqueIdGenerator.generateUniqueId(this.getStudentId() +
                this.getClassId() + this.getFeeMonthEpoch());
        this.status = "pending";
    }
}
