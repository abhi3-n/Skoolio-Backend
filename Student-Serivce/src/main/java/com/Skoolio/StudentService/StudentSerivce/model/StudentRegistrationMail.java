package com.Skoolio.StudentService.StudentSerivce.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class StudentRegistrationMail implements Serializable {
    private String studentMail;
    private String school; //TODO: Later will be school ID, mail service will fetch school mail details itself.
    private String applicationID;
    //Subject and body of the mail to be decided by mail service itself. This enables single point of change.
}
