package com.Skoolio.SchoolService.SchoolService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SchoolContactDetails {
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String primaryContact;
    private String secondaryContact;
}
