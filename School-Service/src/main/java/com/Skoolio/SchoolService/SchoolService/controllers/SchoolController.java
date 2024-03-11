package com.Skoolio.SchoolService.SchoolService.controllers;


import com.Skoolio.SchoolService.SchoolService.entities.School;
import com.Skoolio.SchoolService.SchoolService.model.RegisterResponse;
import com.Skoolio.SchoolService.SchoolService.services.SchoolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    @PostMapping
    public ResponseEntity<?> registerSchool(@RequestBody School school){
        System.out.println("Request Recieved");
        school.setRegistrationDate(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
        School savedSchool = schoolService.saveSchool(school);
        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(savedSchool.getSchoolId().toString(),"registered"));
    }

    @GetMapping("/{schoolId}")
    public ResponseEntity<?> getSchoolById(@PathVariable String school){
        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse("","registered"));
    }

}
