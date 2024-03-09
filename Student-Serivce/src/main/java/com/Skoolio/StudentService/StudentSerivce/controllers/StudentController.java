package com.Skoolio.StudentService.StudentSerivce.controllers;


import com.Skoolio.StudentService.StudentSerivce.entities.RegisterResponse;
import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import com.Skoolio.StudentService.StudentSerivce.model.TempClass;
import com.Skoolio.StudentService.StudentSerivce.services.KafkaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping
    public ResponseEntity<?> registerStudent(
            @RequestBody Student student
    ){
        System.out.println("Request Recieved");
        student.setRegistrationDate(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
        System.out.println(student.toString());
        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse("123","registered"));
    }

    @GetMapping
    public ResponseEntity<?> sendEmail(@RequestBody TempClass tempClass) throws JsonProcessingException {
        kafkaService.sendEmail(tempClass);

        return ResponseEntity.status(HttpStatus.OK).body("Email Sent");
    }
}
