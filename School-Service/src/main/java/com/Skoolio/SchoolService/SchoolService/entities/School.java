package com.Skoolio.SchoolService.SchoolService.entities;

import com.Skoolio.SchoolService.SchoolService.model.AddressDetails;
import com.Skoolio.SchoolService.SchoolService.model.SchoolContactDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    private String schoolId;
    private String schoolName;
    private AddressDetails addressDetails;
    private SchoolContactDetails schoolContactDetails;
    private Long registrationDate;
    private String schoolActiveStatus;
}
