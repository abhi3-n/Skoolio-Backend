package com.Skoolio.SchoolService.SchoolService.controllers;

import com.Skoolio.SchoolService.SchoolService.entities.SchoolAdministrator;
import com.Skoolio.SchoolService.SchoolService.services.SchoolAdminService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class SchoolAdminsController {
    @Autowired
    private SchoolAdminService schoolAdminService;

    @GetMapping("/{schoolId}")
    public ResponseEntity<?> getAllSchoolAdminsBySchoolId(@PathVariable String schoolId){
        List<SchoolAdministrator> adminList = schoolAdminService.getAdminsBySchoolId(Integer.valueOf(schoolId));
        return ResponseEntity.status(HttpStatus.OK).body(adminList);
    }
}
