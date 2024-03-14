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
public class SchoolAdministrator {
    @Id
    private String adminID;
    @Column(nullable = false)
    private String firstName;
    private String middleName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Long dob;
    @Column(nullable = false)
    private Character gender;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Embedded
    private AdminContactDetails adminContactDetails;
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
        this.adminID = UniqueIdGenerator.generateAdminId(this.schoolId.getSchoolId().toString() + this.email);
    }

    public void toLowerCase(){
        this.firstName = this.firstName.toLowerCase();
        this.middleName = this.middleName.toLowerCase();
        this.lastName = this.lastName.toLowerCase();

        this.adminContactDetails.setPrimaryContactName(this.adminContactDetails.getPrimaryContactName().toLowerCase());
        this.adminContactDetails.setAlternativeContactName(this.adminContactDetails.getAlternativeContactName().toLowerCase());

        this.addressDetails.setAddressLine(this.addressDetails.getAddressLine().toLowerCase());
        this.addressDetails.setState(this.addressDetails.getState().toLowerCase());
        this.addressDetails.setCity(this.addressDetails.getCity().toLowerCase());
    }


}
