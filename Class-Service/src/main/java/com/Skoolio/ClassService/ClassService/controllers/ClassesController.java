package com.Skoolio.ClassService.ClassService.controllers;


import com.Skoolio.ClassService.ClassService.entities._Class;
import com.Skoolio.ClassService.ClassService.repositories.ClassRepository;
import com.Skoolio.ClassService.ClassService.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassService classService;

    @GetMapping("/{schoolId}")
    public ResponseEntity<List<_Class>> findBySchoolId(@PathVariable String schoolId){
        List<_Class> lst = classService.findBySchoolId(Integer.valueOf(schoolId));
        return ResponseEntity.status(HttpStatus.OK).body(lst);
    }

    //This endpoint provides a list of classes (classId, grade, section) for given schoolId and grade(admissionClass). So that admin can assign a classs to student, who is seeking approval
    @GetMapping("/classInfoList/{schoolId}/{admissionClass}")
    public ResponseEntity<List<ClassRepository._ClassInfo>> getClassInfoList(@PathVariable String schoolId, @PathVariable String admissionClass){
        System.out.println("schoolid - "+schoolId+", admissionClass - "+admissionClass);
        return classService.getClassInfoList(Integer.valueOf(schoolId),admissionClass);
    }

}
