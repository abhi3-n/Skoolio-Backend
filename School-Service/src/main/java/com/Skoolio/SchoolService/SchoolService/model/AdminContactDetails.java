package com.Skoolio.SchoolService.SchoolService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class AdminContactDetails {
    @Column(nullable = false)
    private String primaryContact;
    @Column(nullable = false)
    private String primaryContactName;
    private String alternativeContact;
    private String alternativeContactName;
}
