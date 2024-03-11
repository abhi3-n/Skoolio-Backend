package com.Skoolio.SchoolService.SchoolService.entities;

import com.Skoolio.SchoolService.SchoolService.model.AddressDetails;
import com.Skoolio.SchoolService.SchoolService.model.AdminContactDetails;
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
    private String gender;
    @Column(nullable = false)
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
}
