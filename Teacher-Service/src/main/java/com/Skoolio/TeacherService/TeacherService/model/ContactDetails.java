package com.Skoolio.TeacherService.TeacherService.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDetails {
    private String primaryContact;
    private String primaryContactName;
    private String alternativeContact;
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
