package com.Skoolio.TeacherService.TeacherService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRegistrationMail implements Serializable {
    private String userMail;
    private Integer schoolId;
    private String applicationID;
}
