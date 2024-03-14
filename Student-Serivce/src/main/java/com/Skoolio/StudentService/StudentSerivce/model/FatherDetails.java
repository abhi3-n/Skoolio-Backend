package com.Skoolio.StudentService.StudentSerivce.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class FatherDetails {
    @Column(nullable = false)
    private String fatherName;
    @Column(nullable = false)
    private String fatherOccupation;
    @Column(nullable = false)
    private String fatherQualification;


    @Override
    public String toString() {
        return "FatherDetails{" +
                "fatherName='" + fatherName + '\'' +
                ", fatherOccupation='" + fatherOccupation + '\'' +
                ", fatherQualification='" + fatherQualification + '\'' +
                '}';
    }
}
