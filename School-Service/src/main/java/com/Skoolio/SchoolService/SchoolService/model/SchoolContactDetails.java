package com.Skoolio.SchoolService.SchoolService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolContactDetails {
    private String email;
    private String primaryContact;
    private String secondaryContact;
}
