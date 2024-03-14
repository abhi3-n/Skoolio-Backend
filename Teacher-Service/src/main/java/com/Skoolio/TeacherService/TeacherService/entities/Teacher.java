package com.Skoolio.TeacherService.TeacherService.entities;

import com.Skoolio.TeacherService.TeacherService.model.AddressDetails;
import com.Skoolio.TeacherService.TeacherService.model.ContactDetails;
import com.Skoolio.TeacherService.TeacherService.model.PreviousEmploymentDetails;
import com.Skoolio.TeacherService.TeacherService.model.TeacherSchoolDetails;
import com.Skoolio.TeacherService.TeacherService.utils.UniqueIdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    private String teacherId;
    @Column(nullable = false)
    private String firstName;
    private String middleName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Long dob;
    @Column(nullable = false)
    private Character gender;
    @Column(nullable = false)
    private String nationality;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Embedded
    private AddressDetails addressDetails;
    @Embedded
    private TeacherSchoolDetails teacherSchoolDetails;
    @Embedded
    private ContactDetails contactDetails;
    @Embedded
    private PreviousEmploymentDetails previousEmploymentDetails; //TODO:Need to review this
    @Column(nullable = false)
    private Long registrationDate;
    @Column(nullable = false)
    private String registrationId;
    private String status;

    public void genRegId() {
        this.setRegistrationId(UniqueIdGenerator.generateUniqueId(this.registrationDate.toString() + this.teacherSchoolDetails.getSchoolId().toString() + this.email));
    }

    public void genTeacherId() {
        this.setTeacherId(UniqueIdGenerator.generateUniqueId(this.registrationId + this.firstName + this.lastName));
    }

    public void toLowerCase() {
        this.firstName = this.firstName.toLowerCase();
        this.middleName = this.middleName.toLowerCase();
        this.lastName = this.lastName.toLowerCase();
        this.nationality = this.nationality.toLowerCase();
        this.addressDetails.setAddressLine(this.addressDetails.getAddressLine().toLowerCase());
        this.addressDetails.setState(this.addressDetails.getState().toLowerCase());
        this.addressDetails.setCity(this.addressDetails.getCity().toLowerCase());
        this.contactDetails.setPrimaryContactName(this.contactDetails.getPrimaryContactName().toLowerCase());
        this.contactDetails.setAlternativeContactName(this.contactDetails.getAlternativeContactName().toLowerCase());
        this.previousEmploymentDetails.setEmployerName(this.previousEmploymentDetails.getEmployerName().toLowerCase());
        this.previousEmploymentDetails.setJobTitle(this.previousEmploymentDetails.getJobTitle().toLowerCase());
    }



    public void readyTeacher() {
        this.setRegistrationDate(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
        this.genRegId();
        this.genTeacherId();
        this.setStatus("approval pending");
        this.toLowerCase();
    }
}
