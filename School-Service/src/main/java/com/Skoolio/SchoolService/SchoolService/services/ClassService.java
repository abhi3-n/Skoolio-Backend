package com.Skoolio.SchoolService.SchoolService.services;

import com.Skoolio.SchoolService.SchoolService.entities._Class;

import java.util.List;

public interface ClassService {

    _Class createClass(_Class _class);
    List<_Class> findBySchoolId(Integer schoolId);

    List<_Class> getAllClass();

}
