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
public class ContactDetails {
    @Column(nullable = false)
    private String primaryContact;
    @Column(nullable = false)
    private String primaryContactName;
    @Column(nullable = false)
    private String primaryContactRelation;
    private String alternativeContact;
    private String alternativeContactName;
    private String alternativeContactRelation;

    @Override
    public String toString() {
        return "ContactDetails{" +
                "primaryContact='" + primaryContact + '\'' +
                ", primaryContactName='" + primaryContactName + '\'' +
                ", primaryContactRelation='" + primaryContactRelation + '\'' +
                ", alternativeContact='" + alternativeContact + '\'' +
                ", alternativeContactName='" + alternativeContactName + '\'' +
                ", alternativeContactRelation='" + alternativeContactRelation + '\'' +
                '}';
    }
}
