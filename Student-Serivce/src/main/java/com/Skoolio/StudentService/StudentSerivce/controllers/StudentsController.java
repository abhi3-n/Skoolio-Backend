package com.Skoolio.StudentService.StudentSerivce.controllers;


import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import com.Skoolio.StudentService.StudentSerivce.model.RegisterResponse;
import com.Skoolio.StudentService.StudentSerivce.services.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{classId}")
    public ResponseEntity<List<Student>> getStudentsByClassId(@PathVariable String classId) {
        List<Student> listOfStudents = studentService.getStudentsByClassId(classId);
        return ResponseEntity.status(HttpStatus.OK).body(listOfStudents);
    }
}
