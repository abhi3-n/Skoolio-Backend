package com.Skoolio.SchoolService.SchoolService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDetails {
    private String addressLine;
    private String city;
    private String state;
    private String pincode;
}
