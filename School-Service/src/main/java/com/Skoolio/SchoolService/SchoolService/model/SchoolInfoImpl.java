package com.Skoolio.SchoolService.SchoolService.model;

import com.Skoolio.SchoolService.SchoolService.repositories.SchoolRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolInfoImpl implements SchoolRepository.SchoolInfo {
    private Integer schoolId;
    private String schoolName;
//    private AddressDetails addressDetails;
    private String addressLine;
    private String city;
    private String state;
    private String pincode;
}
