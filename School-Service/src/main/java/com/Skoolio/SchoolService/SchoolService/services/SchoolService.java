package com.Skoolio.SchoolService.SchoolService.services;

import com.Skoolio.SchoolService.SchoolService.entities.School;

import java.util.List;

public interface SchoolService {

    //save a school
    School saveSchool(School school);

    //get all school info
    List<School> getAllSchool();

    //get a school
    School getSchool(Integer schoolId);

}
