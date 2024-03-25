package com.Skoolio.TeacherService.TeacherService.controllers;



import com.Skoolio.TeacherService.TeacherService.entities.Teacher;
import com.Skoolio.TeacherService.TeacherService.model.RegisterResponse;
import com.Skoolio.TeacherService.TeacherService.model.login.LoginRequest;
import com.Skoolio.TeacherService.TeacherService.model.login.LoginResponse;
import com.Skoolio.TeacherService.TeacherService.services.KafkaService;
import com.Skoolio.TeacherService.TeacherService.services.MailService;
import com.Skoolio.TeacherService.TeacherService.services.TeacherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private MailService mailService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private KafkaService kafkaService;

    @PostMapping
    @Operation(summary = "This endpoint is used to register a teacher.")
    public ResponseEntity<?> registerTeacher(@RequestBody Teacher teacher) throws JsonProcessingException {
        Teacher teacher1 = teacherService.createTeacher(teacher);
        mailService.sendTeacherRegistrationMail(teacher.getEmail(), teacher.getRegistrationId(), teacher.getTeacherSchoolDetails().getSchoolId());

        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(teacher1.getRegistrationId(),"registered"));
    }

    @GetMapping("/{teacherId}")
    @Operation(summary = "This endpoint is used to get the information about a teacher by teacherId.")
    public ResponseEntity<?> getTeacherById(@PathVariable String teacherId){
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(teacher);
    }

    @PatchMapping("/approve/{teacherId}")
    @Operation(summary = "This endpoint is used to approve teacher registration.")
    public ResponseEntity<String> approveTeacher(@PathVariable String teacherId){
        teacherService.approveTeacher(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body("Approval succeeded");
    }

    @PostMapping("/login")
    @Operation(summary = "This endpoint is used to verify login for teacher.")
    public ResponseEntity<LoginResponse> teacherLogin(@RequestBody LoginRequest loginRequest){
        return teacherService.teacherLogin(loginRequest);
    }

}
