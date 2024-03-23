package com.Skoolio.SchoolService.SchoolService.model.login;


import com.Skoolio.SchoolService.SchoolService.entities.SchoolAdministrator;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private String status;
    private String message;
    private SchoolAdministrator schoolAdministrator;
}
