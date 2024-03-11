package com.Skoolio.SchoolService.SchoolService.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminContactDetails {
    private String primaryContact;
    private String primaryContactName;
    private String alternativeContact;
    private String alternativeContactName;
}
