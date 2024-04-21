package com.Skoolio.StudentService.StudentSerivce.model.userDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordChangeRequest {
    private String email;
    private String newPassword;
}
