package com.Skoolio.SchoolService.SchoolService.controllers;

import com.Skoolio.SchoolService.SchoolService.entities.SchoolAdministrator;
import com.Skoolio.SchoolService.SchoolService.model.RegisterResponse;
import com.Skoolio.SchoolService.SchoolService.model.login.LoginRequest;
import com.Skoolio.SchoolService.SchoolService.model.login.LoginResponse;
import com.Skoolio.SchoolService.SchoolService.services.SchoolAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/admin")
public class SchoolAdminController {
    @Autowired
    private SchoolAdminService schoolAdminService;
    @PostMapping
    public ResponseEntity<?> registerAdmin(@RequestBody SchoolAdministrator schoolAdministrator){
        schoolAdministrator.setRegistrationDate(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
        SchoolAdministrator savedSchoolAdministrator = schoolAdminService.createAdmin(schoolAdministrator);
        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(savedSchoolAdministrator.getAdminId(),"registered"));
    }

    @GetMapping("/{adminId}")
    public  ResponseEntity<?> getAdmin(@PathVariable String adminId){
        SchoolAdministrator schoolAdministrator = schoolAdminService.getAdminById(adminId);
        return ResponseEntity.status(HttpStatus.OK).body(schoolAdministrator);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> adminLogin(@RequestBody LoginRequest loginRequest){
        return schoolAdminService.adminLogin(loginRequest);
    }
}
