package com.Skoolio.SchoolService.SchoolService.controllers;


import com.Skoolio.SchoolService.SchoolService.model.ClassInfoRequest;
import com.Skoolio.SchoolService.SchoolService.repositories.ClassRepository;
import com.Skoolio.SchoolService.SchoolService.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassService classService;
    @GetMapping("/classInfoList/{schoolId}/{admissionClass}")
    public ResponseEntity<List<ClassRepository._ClassInfo>> getClassInfoList(@PathVariable String schoolId, @PathVariable String admissionClass){
        System.out.println("schoolid - "+schoolId+", admissionClass - "+admissionClass);
        return classService.getClassInfoList(Integer.valueOf(schoolId),admissionClass);
    }

    @GetMapping("/abc/{schoolId}/{admissionClass}")
    public void getClass(@PathVariable String schoolId, @PathVariable String admissionClass){
        System.out.println("schoolid - "+schoolId+", admissionClass - "+admissionClass);
    }

}
