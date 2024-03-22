package com.Skoolio.SchoolService.SchoolService.services;

import com.Skoolio.SchoolService.SchoolService.repositories.SchoolRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SchoolService {

    //save a school
    com.Skoolio.SchoolService.SchoolService.entities.School saveSchool(com.Skoolio.SchoolService.SchoolService.entities.School school);

    //get all school info
    List<com.Skoolio.SchoolService.SchoolService.entities.School> getAllSchools();

    //get a school
    com.Skoolio.SchoolService.SchoolService.entities.School getSchool(Integer schoolId);


    List<SchoolRepository.SchoolInfo> getSchoolsByCity(String city);

    ResponseEntity<List<String>> getCitiesList();

}
