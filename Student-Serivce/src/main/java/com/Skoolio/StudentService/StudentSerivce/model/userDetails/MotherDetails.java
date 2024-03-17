package com.Skoolio.StudentService.StudentSerivce.model.userDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class MotherDetails {
    @Column(nullable = false)
    private String motherName;
    @Column(nullable = false)
    private String motherOccupation;
    @Column(nullable = false)
    private String motherQualification;

    @Override
    public String toString() {
        return "MotherDetails{" +
                "motherName='" + motherName + '\'' +
                ", motherOccupation='" + motherOccupation + '\'' +
                ", motherQualification='" + motherQualification + '\'' +
                '}';
    }
}
