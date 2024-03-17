package com.Skoolio.StudentService.StudentSerivce.controllers;


import com.Skoolio.StudentService.StudentSerivce.model.login.LoginRequest;
import com.Skoolio.StudentService.StudentSerivce.model.login.LoginResponse;
import com.Skoolio.StudentService.StudentSerivce.model.responses.RegisterResponse;
import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import com.Skoolio.StudentService.StudentSerivce.services.KafkaService;
import com.Skoolio.StudentService.StudentSerivce.services.MailService;
import com.Skoolio.StudentService.StudentSerivce.services.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.common.security.auth.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private MailService mailService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private KafkaService kafkaService;

    @PostMapping
    public ResponseEntity<?> registerStudent(@RequestBody Student student) throws JsonProcessingException {
        System.out.println(student.toString());
        Student student1 = studentService.createStudent(student);
        mailService.sendStudentRegistrationMail(student.getEmail(), student1.getRegistrationId(), String.valueOf(student.getStudentSchoolDetails().getSchoolId()));
        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(student1.getRegistrationId(),"registered"));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable String studentId) {
        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }


    @GetMapping("/login")
    public ResponseEntity<LoginResponse> studentLogin(@RequestBody LoginRequest loginRequest){
        return studentService.studentLogin(loginRequest);
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
//        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(loginResponse);

    }

    @PatchMapping("/approve/{studentId}")
    public ResponseEntity<String> approveStudent(@PathVariable String studentId){
        studentService.approveStudent(studentId);
        return ResponseEntity.status(HttpStatus.OK).body("Approval succeeded");
    }
}
