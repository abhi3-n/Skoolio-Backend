package com.Skoolio.TeacherService.TeacherService.entities;

import com.Skoolio.TeacherService.TeacherService.model.AddressDetails;
import com.Skoolio.TeacherService.TeacherService.model.ContactDetails;
import com.Skoolio.TeacherService.TeacherService.model.PreviousEmploymentDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
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
    private PreviousEmploymentDetails previousEmploymentDetails;

    @Override
    public String toString() {
        return "Teacher{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", password='" + password + '\'' +
                ", addressDetails=" + addressDetails +
                ", previousEmploymentDetails=" + previousEmploymentDetails +
                ", contactDetails=" + contactDetails +
                ", registrationDate=" + registrationDate +
                ", status='" + status + '\'' +
                '}';
    }

    private ContactDetails contactDetails;
    private Long registrationDate;
    private String status = "Approval Pending";
}
