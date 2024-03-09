package com.Skoolio.StudentService.StudentSerivce.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDetails {
    private String primaryContact;
    private String primaryContactName;
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
