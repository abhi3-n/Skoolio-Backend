package com.Skoolio.SchoolService.SchoolService.entities;

import com.Skoolio.SchoolService.SchoolService.model.AddressDetails;
import com.Skoolio.SchoolService.SchoolService.model.AdminContactDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private String firstName;
    private String middleName;
    private String lastName;
    private Long dob;
    private String gender;
    private String email;
    private String password;
    private AdminContactDetails adminContactDetails;
    private AddressDetails addressDetails;
    private Long registrationDate;
    private String adminStatus;
}
