package com.Skoolio.TeacherService.TeacherService.controllers;



import com.Skoolio.TeacherService.TeacherService.entities.Teacher;
import com.Skoolio.TeacherService.TeacherService.model.RegisterResponse;
import com.Skoolio.TeacherService.TeacherService.model.login.LoginRequest;
import com.Skoolio.TeacherService.TeacherService.model.login.LoginResponse;
import com.Skoolio.TeacherService.TeacherService.services.KafkaService;
import com.Skoolio.TeacherService.TeacherService.services.MailService;
import com.Skoolio.TeacherService.TeacherService.services.TeacherService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public ResponseEntity<?> registerTeacher(@RequestBody Teacher teacher) throws JsonProcessingException {
        Teacher teacher1 = teacherService.createTeacher(teacher);
        mailService.sendTeacherRegistrationMail(teacher.getEmail(), teacher.getRegistrationId(), teacher.getTeacherSchoolDetails().getSchoolId());

        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(teacher1.getRegistrationId(),"registered"));
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<?> getTeacherById(@PathVariable String teacherId){
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(teacher);
    }

    @PatchMapping("/approve/{teacherId}")
    public ResponseEntity<String> approveTeacher(@PathVariable String teacherId){
        teacherService.approveTeacher(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body("Approval succeeded");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> studentLogin(@RequestBody LoginRequest loginRequest){
        return teacherService.teacherLogin(loginRequest);
    }

}
