package com.Skoolio.SchoolService.SchoolService.controllers;

import com.Skoolio.SchoolService.SchoolService.entities.SchoolAdministrator;
import com.Skoolio.SchoolService.SchoolService.model.RegisterResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/admin")
public class SchoolAdminController {
    @PostMapping
    public ResponseEntity<?> registerAdmin(@RequestBody SchoolAdministrator schoolAdministrator){
        System.out.println("Request Recieved");
        schoolAdministrator.setRegistrationDate(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));

        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse("123","registered"));
    }
}
