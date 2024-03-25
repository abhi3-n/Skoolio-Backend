package com.Skoolio.TeacherService.TeacherService.controllers;

import com.Skoolio.TeacherService.TeacherService.entities.Teacher;
import com.Skoolio.TeacherService.TeacherService.services.TeacherService;
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
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{schoolId}")
    @Operation(summary = "This endpoint is used to fetch teachers of a school.")
    public ResponseEntity<?> getTeacherBySchoolId(@PathVariable String schoolId){
        List<Teacher> listOfTeachers = teacherService.getTeachersBySchoolId(Integer.valueOf(schoolId));
        return ResponseEntity.status(HttpStatus.OK).body(listOfTeachers);
    }

    //Returns list of student Ids whose registration approval is pending.
    @GetMapping("/approvalPending/{schoolId}")
    @Operation(summary = "This endpoint is used to fetch teachers whose registration approval is pending.")
    public ResponseEntity<List<Teacher>> getStudentsWithPendingApproval(@PathVariable String schoolId){
        List<Teacher> list = teacherService.getTeachersWithPendingApproval(Integer.valueOf(schoolId));
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
