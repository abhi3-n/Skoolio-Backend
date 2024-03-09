package com.Skoolio.TeacherService.TeacherService.controllers;


import com.Skoolio.TeacherService.TeacherService.entities.Teacher;
import com.Skoolio.TeacherService.TeacherService.model.RegisterResponse;
import com.Skoolio.TeacherService.TeacherService.services.KafkaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private KafkaService kafkaService;

    @PostMapping
    public ResponseEntity<?> registerTeacher(
            @RequestBody Teacher teacher
    ) throws JsonProcessingException {
        System.out.println("Request Recieved");
        teacher.setRegistrationDate(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
//        System.out.println(teacher.toString());
//        //TODO:Generate Application ID
//
//
//        sendTeacherRegistrationMail(teacher.getEmail(), "123", teacher.getStudentSchoolDetails().getSchool());

        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse("123","registered"));
    }
}
