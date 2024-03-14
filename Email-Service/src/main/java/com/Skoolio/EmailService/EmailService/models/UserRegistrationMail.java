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
public class UserRegistrationMail {
    private String userMail;
    private Integer schoolId; 
    private String applicationID;
}
