package com.Skoolio.EmailService.EmailService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailOtpRequest {
    private String email;
    //remove temp later
    private String temp = "";
}
