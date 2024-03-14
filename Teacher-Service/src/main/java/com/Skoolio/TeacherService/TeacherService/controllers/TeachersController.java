package com.Skoolio.TeacherService.TeacherService.controllers;

import com.Skoolio.TeacherService.TeacherService.entities.Teacher;
import com.Skoolio.TeacherService.TeacherService.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{schoolId}")
    public ResponseEntity<?> getTeacherBySchoolId(@PathVariable String schoolId){
        List<Teacher> listOfTeachers = teacherService.getTeachersBySchoolId(Integer.valueOf(schoolId));
        return ResponseEntity.status(HttpStatus.OK).body(listOfTeachers);
    }
}
