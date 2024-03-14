package com.Skoolio.StudentService.StudentSerivce.entities;

import com.Skoolio.StudentService.StudentSerivce.model.*;
import com.Skoolio.StudentService.StudentSerivce.utils.UniqueIdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Student {
    @Id
    private String studentId;
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
    private StudentSchoolDetails studentSchoolDetails;
    @Embedded
    private FatherDetails father;
    @Embedded
    private MotherDetails mother;
    @Embedded
    private ContactDetails contactDetails;
    @Column(nullable = false)
    private Long registrationDate;
    @Column(nullable = false)
    private String registrationId;
    @Column(nullable = false)
    private String status;
    private String mot;

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", nationality='" + nationality + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", addressDetails=" + addressDetails +
                ", studentSchoolDetails=" + studentSchoolDetails +
//                ", father=" + father +
//                ", mother=" + mother +
                ", contactDetails=" + contactDetails +
                ", registrationDate=" + registrationDate +
                ", registrationId='" + registrationId + '\'' +
                ", status='" + status + '\'' +
                ", mot='" + mot + '\'' +
                '}';
    }

    public void genStudentId(){
        this.setStudentId(UniqueIdGenerator.generateUniqueId(this.registrationId + this.firstName + this.lastName));
    }

    public void toLowerCase(){
        this.firstName = this.firstName.toLowerCase();
        this.middleName = this.middleName.toLowerCase();
        this.lastName = this.lastName.toLowerCase();
        this.nationality = this.nationality.toLowerCase();
        this.addressDetails.setAddressLine(this.addressDetails.getAddressLine().toLowerCase());
        this.addressDetails.setState(this.addressDetails.getState().toLowerCase());
        this.addressDetails.setCity(this.addressDetails.getCity().toLowerCase());
        this.contactDetails.setPrimaryContactName(this.contactDetails.getPrimaryContactName().toLowerCase());
        this.contactDetails.setPrimaryContactRelation(this.contactDetails.getPrimaryContactRelation().toLowerCase());
        this.contactDetails.setAlternativeContactName(this.contactDetails.getAlternativeContactName().toLowerCase());
        this.contactDetails.setAlternativeContactRelation(this.contactDetails.getAlternativeContactRelation().toLowerCase());

        this.father.setFatherName(this.father.getFatherName().toLowerCase());
        this.father.setFatherOccupation(this.father.getFatherOccupation().toLowerCase());
        this.father.setFatherQualification(this.father.getFatherQualification().toLowerCase());


        this.mother.setMotherName(this.mother.getMotherName().toLowerCase());
        this.mother.setMotherOccupation(this.mother.getMotherOccupation().toLowerCase());
        this.mother.setMotherQualification(this.mother.getMotherQualification().toLowerCase());
        this.setMot(this.getMot().toLowerCase());
    }

    public void genRegId(){
        this.setRegistrationId(UniqueIdGenerator.generateUniqueId(this.registrationDate.toString() + this.studentSchoolDetails.getSchoolId().toString() + this.studentSchoolDetails.getClassId() + this.email));
    }

    public void readyStudent() {
        this.setRegistrationDate(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
        this.genRegId();
        this.genStudentId();
        this.toLowerCase();
        this.setStatus("approval pending");
    }
}
