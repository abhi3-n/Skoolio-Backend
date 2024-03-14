package com.Skoolio.StudentService.StudentSerivce.controllers;


import com.Skoolio.StudentService.StudentSerivce.model.RegisterResponse;
import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import com.Skoolio.StudentService.StudentSerivce.model.StudentRegistrationMail;
import com.Skoolio.StudentService.StudentSerivce.services.KafkaService;
import com.Skoolio.StudentService.StudentSerivce.services.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private KafkaService kafkaService;

    @PostMapping
    public ResponseEntity<?> registerStudent(@RequestBody Student student) throws JsonProcessingException {
        System.out.println(student.toString());

        Student student1 = studentService.createStudent(student);
        sendStudentRegistrationMail(student.getEmail(), student1.getRegistrationId(), String.valueOf(student.getStudentSchoolDetails().getSchoolId()));
        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(student1.getRegistrationId(),"registered"));
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
