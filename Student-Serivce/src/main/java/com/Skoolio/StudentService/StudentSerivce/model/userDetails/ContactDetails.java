package com.Skoolio.StudentService.StudentSerivce.model.userDetails;

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
    @Column(nullable = false)
    private String alternativeContact;
    @Column(nullable = false)
    private String alternativeContactName;
    @Column(nullable = false)
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
