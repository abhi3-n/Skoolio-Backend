package com.Skoolio.ClassService.ClassService.controllers;


import com.Skoolio.ClassService.ClassService.entities._Class;
import com.Skoolio.ClassService.ClassService.repositories.ClassRepository;
import com.Skoolio.ClassService.ClassService.services.ClassService;
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
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassService classService;

    @GetMapping("/{schoolId}")
    @Operation(summary = "This endpoint is used to get classes of a school.")
    public ResponseEntity<List<_Class>> findBySchoolId(@PathVariable String schoolId){
        List<_Class> listOfClasses = classService.findBySchoolId(Integer.valueOf(schoolId));
        return ResponseEntity.status(HttpStatus.OK).body(listOfClasses);
    }

    @GetMapping("/classInfo/{schoolId}")
    @Operation(summary = "This endpoint is used to get list of classInfo of a school.")
    public ResponseEntity<List<ClassRepository._ClassInfo>> findClassInfoBySchoolId(@PathVariable String schoolId){
        try {
            List<ClassRepository._ClassInfo> listOfClassInfo = classService.findClassInfoBySchoolId(Integer.valueOf(schoolId));
            return ResponseEntity.status(HttpStatus.OK).body(listOfClassInfo);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/classTeacherId/{classTeacherId}")
    @Operation(summary = "This endpoint is used to get classes for a class teacher id.")
    public ResponseEntity<List<_Class>> findByClassTeacherId(@PathVariable String classTeacherId){
        List<_Class> listOfClasses = classService.findByClassTeacherId(classTeacherId);
        return ResponseEntity.status(HttpStatus.OK).body(listOfClasses);
    }

    @GetMapping("/classTeacherId/classInfo/{classTeacherId}")
    @Operation(summary = "This endpoint is used to get ClassInfo of classes for a class teacher id.")
    public ResponseEntity<List<ClassRepository._ClassInfo>> findClassInfoByTeacherId(@PathVariable String classTeacherId){
        return classService.getClassInfoListForTeacherId(classTeacherId);
    }

    //This endpoint provides a list of classes (classId, grade, section) for given schoolId and grade(admissionClass). So that admin can assign a classs to student, who is seeking approval
    @GetMapping("/classInfoList/{schoolId}/{admissionClass}")
    @Operation(summary = "This endpoint is used to get ClassInfo(classId, grade and section) list for a school and grade.")
    public ResponseEntity<List<ClassRepository._ClassInfo>> getClassInfoList(@PathVariable String schoolId, @PathVariable String admissionClass){
        return classService.getClassInfoList(Integer.valueOf(schoolId),admissionClass);
    }



}
