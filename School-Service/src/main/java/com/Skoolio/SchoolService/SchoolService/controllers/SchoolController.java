package com.Skoolio.SchoolService.SchoolService.controllers;


import com.Skoolio.SchoolService.SchoolService.entities.School;
import com.Skoolio.SchoolService.SchoolService.model.RegisterResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @PostMapping
    public ResponseEntity<?> registerSchool(@RequestBody School school){
        System.out.println("Request Recieved");
        school.setRegistrationDate(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));

        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse("123","registered"));
    }

}
