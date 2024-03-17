package com.Skoolio.StudentService.StudentSerivce.model.mailDetails;


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
    private String userMail;
    private String schoolId;
    private String applicationID;
    //Subject and body of the mail to be decided by mail service itself. This enables single point of change.
}
