package com.Skoolio.SchoolService.SchoolService.controllers;


import com.Skoolio.SchoolService.SchoolService.entities._Class;
import com.Skoolio.SchoolService.SchoolService.model.RegisterResponse;
import com.Skoolio.SchoolService.SchoolService.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;
    @PostMapping
    public ResponseEntity<?> createClass(@RequestBody _Class _class){
        _class.toLowerCase();
        _Class _class1 = classService.createClass(_class);
        return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(_class1.getClassId().toString(),"created"));
    }

    @GetMapping("/{schoolId}")
    public ResponseEntity<List<_Class>> findBySchoolId(@PathVariable String schoolId){
        List<_Class> lst = classService.findBySchoolId(Integer.valueOf(schoolId));
        return ResponseEntity.status(HttpStatus.OK).body(lst);
    }

    @GetMapping("/classListForSchool/{schoolId}")
    public ResponseEntity<List<String>> getClassNameListForSchool(@PathVariable String schoolId){
        return classService.getClassNameListForSchool(Integer.valueOf(schoolId));
    }
}
