package com.Skoolio.TeacherService.TeacherService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRegistrationMail {
    private String teacherMail;
    private String school; //TODO: Later will be school ID, mail service will fetch school mail details itself.
    private String applicationID;
}
