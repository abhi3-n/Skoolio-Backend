package com.Skoolio.StudentService.StudentSerivce.controllers;


import com.Skoolio.StudentService.StudentSerivce.entities.RegisterResponse;
import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import com.Skoolio.StudentService.StudentSerivce.model.StudentRegistrationMail;
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
    ) throws JsonProcessingException {
        System.out.println("Request Recieved");
        student.setRegistrationDate(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
        System.out.println(student.toString());
        //TODO:Generate Application ID


        sendStudentRegistrationMail(student.getEmail(), "123", student.getStudentSchoolDetails().getSchool());

        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse("123","registered"));
    }


    //This get method function is only for testing purposes with postman
    @GetMapping
    public ResponseEntity<?> sendEmail(@RequestBody StudentRegistrationMail studentRegistrationMail) throws JsonProcessingException {
        kafkaService.sendStudentRegistrationMail(studentRegistrationMail);

        return ResponseEntity.status(HttpStatus.OK).body("Email Sent");
    }


    private void sendStudentRegistrationMail(String email, String number, String school) throws JsonProcessingException {
        StudentRegistrationMail studentRegistrationMail = new StudentRegistrationMail();
        studentRegistrationMail.setStudentMail(email);
        studentRegistrationMail.setApplicationID(number); //TODO:application ID to be generated.
        studentRegistrationMail.setSchool(school); //TODO:schoolid to be passed
        kafkaService.sendStudentRegistrationMail(studentRegistrationMail);
    }
}
