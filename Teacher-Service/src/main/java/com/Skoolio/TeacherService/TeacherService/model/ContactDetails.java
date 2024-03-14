package com.Skoolio.TeacherService.TeacherService.model;


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
    private String alternativeContact;
    @Column(nullable = false)
    private String alternativeContactName;

    @Override
    public String toString() {
        return "ContactDetails{" +
                "primaryContact='" + primaryContact + '\'' +
                ", primaryContactName='" + primaryContactName + '\'' +
                ", alternativeContact='" + alternativeContact + '\'' +
                ", alternativeContactName='" + alternativeContactName + '\'' +
                '}';
    }
}
