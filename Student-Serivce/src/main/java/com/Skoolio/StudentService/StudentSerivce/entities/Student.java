package com.Skoolio.StudentService.StudentSerivce.entities;

import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Entity
@Builder
public class Student {
    @Id
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private Long dob;
    private String gender;
    private String nationality;
    private String password;
    private AddressDetails addressDetails;
    private StudentSchoolDetails studentSchoolDetails;
    private GuardianDetails father;
    private GuardianDetails mother;
    private ContactDetails contactDetails;
    private Long registrationDate;
    private String status = "Approval Pending";
    private String mot;

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", password='" + password + '\'' +
                ", addressDetails=" + addressDetails +
                ", studentSchoolDetails=" + studentSchoolDetails +
                ", father=" + father +
                ", mother=" + mother +
                ", contactDetails=" + contactDetails +
                ", registrationDate=" + registrationDate +
                ", status='" + status + '\'' +
                ", mot='" + mot + '\'' +
                '}';
    }
}
