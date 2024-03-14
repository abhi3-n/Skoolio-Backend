package com.Skoolio.TeacherService.TeacherService.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class TeacherSchoolDetails {
    @Column(nullable = false)
    private Integer schoolId;
}
