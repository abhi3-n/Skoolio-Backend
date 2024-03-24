package com.Skoolio.SchoolService.SchoolService.entities;

import com.Skoolio.SchoolService.SchoolService.model.AddressDetails;
import com.Skoolio.SchoolService.SchoolService.model.AdminContactDetails;
import com.Skoolio.SchoolService.SchoolService.utils.UniqueIdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "admin")
public class SchoolAdministrator {
    @Id
    private String adminId;
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
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Embedded
    private AdminContactDetails contactDetails;
    @Embedded
    private AddressDetails addressDetails;
    @Column(nullable = false)
    private Long registrationDate;
    @Column(nullable = false)
    private String adminStatus;
    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private School schoolId;


    public void genAdminId(){
        this.adminId = UniqueIdGenerator.generateUniqueId(this.schoolId.getSchoolId().toString() + this.email);
    }

    public void toLowerCase(){
        this.firstName = this.firstName.toLowerCase();
        this.middleName = this.middleName.toLowerCase();
        this.lastName = this.lastName.toLowerCase();

        this.contactDetails.setPrimaryContactName(this.contactDetails.getPrimaryContactName().toLowerCase());
        this.contactDetails.setAlternativeContactName(this.contactDetails.getAlternativeContactName().toLowerCase());

        this.addressDetails.setAddressLine(this.addressDetails.getAddressLine().toLowerCase());
        this.addressDetails.setState(this.addressDetails.getState().toLowerCase());
        this.addressDetails.setCity(this.addressDetails.getCity().toLowerCase());
    }


}
