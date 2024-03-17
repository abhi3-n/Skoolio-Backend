package com.Skoolio.StudentService.StudentSerivce.controllers;


import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import com.Skoolio.StudentService.StudentSerivce.services.StudentService;
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


    //Returns list of student Ids whose registration approval is pending.
    @GetMapping("/approvalPending/{schoolId}")
    public ResponseEntity<List<Student>> getStudentsWithPendingApproval(@PathVariable Integer schoolId){
        List<Student> list = studentService.getStudentsWithPendingApproval(schoolId);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
