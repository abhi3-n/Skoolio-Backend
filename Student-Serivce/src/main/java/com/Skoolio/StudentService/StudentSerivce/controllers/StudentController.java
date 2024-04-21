package com.Skoolio.StudentService.StudentSerivce.controllers;


import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import com.Skoolio.StudentService.StudentSerivce.model.login.LoginRequest;
import com.Skoolio.StudentService.StudentSerivce.model.login.LoginResponse;
import com.Skoolio.StudentService.StudentSerivce.model.responses.RegisterResponse;
import com.Skoolio.StudentService.StudentSerivce.model.userDetails.PasswordChangeRequest;
import com.Skoolio.StudentService.StudentSerivce.model.userDetails.UpdateAddressDetails;
import com.Skoolio.StudentService.StudentSerivce.model.userDetails.UpdateContactDetails;
import com.Skoolio.StudentService.StudentSerivce.services.KafkaService;
import com.Skoolio.StudentService.StudentSerivce.services.MailService;
import com.Skoolio.StudentService.StudentSerivce.services.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    @Operation(summary = "This endpoint is used to register a student.")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) throws JsonProcessingException {
        System.out.println(student.toString());
        Student student1 = studentService.createStudent(student);
        mailService.sendStudentRegistrationMail(student.getEmail(), student1.getRegistrationId(), String.valueOf(student.getStudentSchoolDetails().getSchoolId()));
        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(student1.getRegistrationId(),"registered"));
    }

    @GetMapping("/{studentId}")
    @Operation(summary = "This endpoint is used to get the information about a student by studentId.")
    public ResponseEntity<Student> getStudentById(@PathVariable String studentId) {
        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping("/name/{studentId}")
    @Operation(summary = "This endpoint is used to get the name of a student by studentId.")
    public ResponseEntity<?> getStudentNameById(@PathVariable String studentId) {
        String name = studentService.getStudentNameById(studentId);
        HashMap hashMap = new HashMap();
        hashMap.put("name",name);
        return ResponseEntity.status(HttpStatus.OK).body(hashMap);
    }


    @PostMapping("/login")
    @Operation(summary = "This endpoint is used to verify login for student.")
    public ResponseEntity<LoginResponse> studentLogin(@RequestBody LoginRequest loginRequest){
        return studentService.studentLogin(loginRequest);
    }

    @PatchMapping("/approve/{studentId}/{classId}")
    @Operation(summary = "This endpoint is used to approve student registration.")
    public ResponseEntity<String> approveStudent(@PathVariable String studentId, @PathVariable String classId){
        studentService.approveStudent(studentId, classId);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @PatchMapping("/address")
    @Operation(summary = "This endpoint is used to update address details of student.")
    public ResponseEntity<?> updateAddress(@RequestBody UpdateAddressDetails updateAddressDetails){
        try {
            studentService.updateAddress(updateAddressDetails);
            HashMap hashMap = new HashMap<>();
            hashMap.put("status", "updated");
            return ResponseEntity.status(HttpStatus.OK).body(hashMap);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping("/contact")
    @Operation(summary = "This endpoint is used to update contact details of student.")
    public ResponseEntity<?> updateContact(@RequestBody UpdateContactDetails updateContactDetails){
        try {
            studentService.updateContact(updateContactDetails);
            HashMap hashMap = new HashMap<>();
            hashMap.put("status", "updated");
            return ResponseEntity.status(HttpStatus.OK).body(hashMap);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping("/changePassword")
    @Operation(summary = "This endpoint is used to update password of student.")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest){
        try {
            studentService.changePassword(passwordChangeRequest);
            HashMap hashMap = new HashMap<>();
            hashMap.put("status", "changed");
            return ResponseEntity.status(HttpStatus.OK).body(hashMap);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/image")
    public ResponseEntity<?> submitStudentImage(@RequestParam String id, @RequestParam MultipartFile image) throws IOException {
        System.out.println("id - "+id);
        System.out.println("image name-" + image.getOriginalFilename());
        studentService.updateImage(id, image);
        HashMap<String,String> hashMap= new HashMap<String, String>();
        hashMap.put("status", "registered");
        return ResponseEntity.status(HttpStatus.OK).body(hashMap);
    }

    @GetMapping("/verifyEmail/{email}")
    @Operation(summary = "This endpoint is used to verify email of a student.")
    public ResponseEntity<?> verifyEmail(@PathVariable String email){
        try {
            studentService.verifyEmail(email);
            HashMap hashMap = new HashMap<>();
            hashMap.put("status", "found");
            return ResponseEntity.status(HttpStatus.OK).body(hashMap);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



}
