package com.Skoolio.SchoolService.SchoolService.controllers;


import com.Skoolio.SchoolService.SchoolService.entities.School;
import com.Skoolio.SchoolService.SchoolService.model.RegisterResponse;
import com.Skoolio.SchoolService.SchoolService.model.SchoolName;
import com.Skoolio.SchoolService.SchoolService.services.SchoolService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "This endpoint is used to register a school.")
    public ResponseEntity<?> registerSchool(@RequestBody School school){
        school.setRegistrationDate(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
        school.toLowerCase();
        School savedSchool = schoolService.saveSchool(school);
        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(savedSchool.getSchoolId().toString(),"registered"));
    }

    @GetMapping("/{schoolId}")
    @Operation(summary = "This endpoint is used to get the information about a school by schoolId.")
    public ResponseEntity<School> getSchoolById(@PathVariable String schoolId){
        School school = schoolService.getSchool(Integer.valueOf(schoolId));
        return ResponseEntity.status(HttpStatus.OK).body(school);
    }


    @GetMapping("/name/{schoolId}")
    @Operation(summary = "This endpoint is used to get the name of school by schoolId.")
    public ResponseEntity<SchoolName> getSchoolNameForSchoolId(@PathVariable String schoolId){
        return schoolService.getSchoolNameForSchoolId(Integer.valueOf(schoolId));
    }

}

