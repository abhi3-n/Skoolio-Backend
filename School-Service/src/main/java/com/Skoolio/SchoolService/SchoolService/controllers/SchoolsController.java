package com.Skoolio.SchoolService.SchoolService.controllers;


import com.Skoolio.SchoolService.SchoolService.entities.School;
import com.Skoolio.SchoolService.SchoolService.repositories.SchoolRepository;
import com.Skoolio.SchoolService.SchoolService.services.SchoolService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "This endpoint is used to get list of all schools.")
    public ResponseEntity<List<School>> getAllSchools(){
        List<School> allSchools = schoolService.getAllSchools();
        //TODO:Need to format registration date into DD/MM/YYYY
        return ResponseEntity.status(HttpStatus.OK).body(allSchools);
    }


    @GetMapping("/cities")
    @Operation(summary = "This endpoint is used to get the cities of schools.")
    public ResponseEntity<List<String>> getCitiesList(){
        return  schoolService.getCitiesList();
    }

    @GetMapping("/{city}")
    @Operation(summary = "This endpoint is used to get the list of schools in a city.")
    public ResponseEntity<List<SchoolRepository.SchoolInfo>> getSchoolsByCity(@PathVariable String city){
        List<SchoolRepository.SchoolInfo> allSchools = schoolService.getSchoolsByCity(city);
        return ResponseEntity.status(HttpStatus.OK).body(allSchools);
    }

}
