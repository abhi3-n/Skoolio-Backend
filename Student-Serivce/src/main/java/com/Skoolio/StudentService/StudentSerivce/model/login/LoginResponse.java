package com.Skoolio.StudentService.StudentSerivce.model.login;

import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private String status;
    private String message;
    private Student student;
}
