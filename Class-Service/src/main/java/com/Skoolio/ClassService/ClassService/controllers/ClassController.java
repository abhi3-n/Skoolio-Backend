package com.Skoolio.ClassService.ClassService.controllers;


import com.Skoolio.ClassService.ClassService.entities._Class;
import com.Skoolio.ClassService.ClassService.model.ClassTeacherIdInfo;
import com.Skoolio.ClassService.ClassService.model.RegisterResponse;
import com.Skoolio.ClassService.ClassService.services.ClassService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;
    @PostMapping
    @Operation(summary = "This endpoint is used to create a class")
    public ResponseEntity<?> createClass(@RequestBody _Class _class){
        _class.toLowerCase();
        _Class _class1 = classService.createClass(_class);
        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(_class1.getClassId().toString(),"created"));
    }

    @GetMapping("/classListForSchool/{schoolId}")
    @Operation(summary = "This endpoint is used to get names of classes of a school")
    public ResponseEntity<List<String>> getClassNameListForSchool(@PathVariable String schoolId){
        return classService.getClassNameListForSchool(Integer.valueOf(schoolId));
    }

    @PatchMapping("classTeacherId")
    @Operation(summary = "This endpoint is used to set class teacher of a class")
    public ResponseEntity<?> setClassTeacherIdForClass(@RequestBody ClassTeacherIdInfo classTeacherIdInfo){
        return classService.setClassTeacherIdForClass(classTeacherIdInfo.getClassId(), classTeacherIdInfo.getClassTeacherId());
    }

    @GetMapping("/fee/{classId}")
    @Operation(summary = "This endpoint is used to get fee amount for a class")
    public ResponseEntity<?> getFeeForClassID(@PathVariable String classId){
        System.out.println(classId);
        Float fee = classService.getFeeForClassID(classId);
        HashMap hashMap = new HashMap();
        hashMap.put("fee",fee);
        return ResponseEntity.status(HttpStatus.OK).body(hashMap);
    }
}
