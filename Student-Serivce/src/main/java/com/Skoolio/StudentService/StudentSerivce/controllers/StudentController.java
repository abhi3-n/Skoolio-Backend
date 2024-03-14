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

import java.util.List;

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

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable String studentId) {
        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }


    private void sendStudentRegistrationMail(String email, String registrationId, String schoolId) throws JsonProcessingException {
        StudentRegistrationMail studentRegistrationMail = new StudentRegistrationMail();
        studentRegistrationMail.setStudentMail(email);
        studentRegistrationMail.setApplicationID(registrationId);
        studentRegistrationMail.setSchoolId(schoolId);
        kafkaService.sendStudentRegistrationMail(studentRegistrationMail);
    }
}
