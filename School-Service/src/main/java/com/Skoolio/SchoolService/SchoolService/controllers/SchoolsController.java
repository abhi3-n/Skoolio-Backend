package com.Skoolio.SchoolService.SchoolService.controllers;


import com.Skoolio.SchoolService.SchoolService.repositories.SchoolRepository;
import com.Skoolio.SchoolService.SchoolService.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolsController{
    @Autowired
    private SchoolService schoolService;
    @GetMapping
    public ResponseEntity<List<com.Skoolio.SchoolService.SchoolService.entities.School>> getAllSchools(){
        List<com.Skoolio.SchoolService.SchoolService.entities.School> allSchools = schoolService.getAllSchools();
        //TODO:Need to format registration date into DD/MM/YYYY
        return ResponseEntity.status(HttpStatus.OK).body(allSchools);
    }


    @GetMapping("/{city}")
    public ResponseEntity<List<SchoolRepository.SchoolInfo>> getSchoolsByCity(@PathVariable String city){
        List<SchoolRepository.SchoolInfo> allSchools = schoolService.getSchoolsByCity(city);
        return ResponseEntity.status(HttpStatus.OK).body(allSchools);
    }
}
