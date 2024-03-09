package com.Skoolio.EmailService.EmailService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class StudentRegistrationMail {
    private String studentMail;
    private String school; //TODO: Later will be school ID, mail service will fetch school mail details itself.
    private String applicationID;
}
