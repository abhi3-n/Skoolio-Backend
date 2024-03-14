package com.Skoolio.TeacherService.TeacherService.model;


import jakarta.persistence.Embeddable;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class PreviousEmploymentDetails {
    private String employerName;
    private String employmentDuration;
    private String jobTitle;
}
