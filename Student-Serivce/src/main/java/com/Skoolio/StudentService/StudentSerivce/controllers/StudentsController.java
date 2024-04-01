package com.Skoolio.StudentService.StudentSerivce.controllers;


import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import com.Skoolio.StudentService.StudentSerivce.repositories.StudentRepository;
import com.Skoolio.StudentService.StudentSerivce.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{classId}")
    @Operation(summary = "This endpoint is used to fetch students' info (full) for a class.")
    public ResponseEntity<List<Student>> getStudentsListByClassId(@PathVariable String classId) {
        List<Student> listOfStudents = studentService.getStudentsListByClassId(classId);
        return ResponseEntity.status(HttpStatus.OK).body(listOfStudents);
    }

    @GetMapping("/info/{classId}")
    @Operation(summary = "This endpoint is used to fetch students' info (minimal) that belong to a class.")
    public ResponseEntity<List<StudentRepository.StudentInfo>> getStudentsInfoByClassId(@PathVariable String classId) {
        List<StudentRepository.StudentInfo> listOfStudents = studentService.getStudentsInfoByClassId(classId);
        return ResponseEntity.status(HttpStatus.OK).body(listOfStudents);
    }


    //Returns list of student Ids whose registration approval is pending.
    @GetMapping("/approvalPending/{schoolId}")
    @Operation(summary = "This endpoint is used to fetch list of students whose approval is pending.")
    public ResponseEntity<List<Student>> getStudentsWithPendingApproval(@PathVariable Integer schoolId){
        List<Student> list = studentService.getStudentsWithPendingApproval(schoolId);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
