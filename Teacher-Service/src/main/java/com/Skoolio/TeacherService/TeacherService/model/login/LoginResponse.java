package com.Skoolio.TeacherService.TeacherService.model.login;

import com.Skoolio.TeacherService.TeacherService.entities.Teacher;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private String status;
    private String message;
    private Teacher teacher;
}
