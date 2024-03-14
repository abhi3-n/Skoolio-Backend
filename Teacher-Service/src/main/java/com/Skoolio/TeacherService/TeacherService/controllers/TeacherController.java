package com.Skoolio.TeacherService.TeacherService.controllers;


import com.Skoolio.TeacherService.TeacherService.entities.Teacher;
import com.Skoolio.TeacherService.TeacherService.model.RegisterResponse;
import com.Skoolio.TeacherService.TeacherService.model.TeacherRegistrationMail;
import com.Skoolio.TeacherService.TeacherService.services.KafkaService;
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
    private TeacherService teacherService;
    @Autowired
    private KafkaService kafkaService;

    @PostMapping
    public ResponseEntity<?> registerTeacher(@RequestBody Teacher teacher) throws JsonProcessingException {
        Teacher teacher1 = teacherService.createTeacher(teacher);
        sendTeacherRegistrationMail(teacher.getEmail(), teacher.getRegistrationId(), teacher.getTeacherSchoolDetails().getSchoolId());

        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(teacher1.getRegistrationId(),"registered"));
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<?> getTeacherById(@PathVariable String teacherId){
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(teacher);
    }


    private void sendTeacherRegistrationMail(String email, String registrationId, Integer schoolId) throws JsonProcessingException {
        TeacherRegistrationMail studentRegistrationMail = new TeacherRegistrationMail();
        studentRegistrationMail.setUserMail(email);
        studentRegistrationMail.setApplicationID(registrationId);
        studentRegistrationMail.setSchoolId(schoolId);
        kafkaService.sendStudentRegistrationMail(studentRegistrationMail);
    }
}
