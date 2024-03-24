package com.Skoolio.SchoolService.SchoolService.services;

import com.Skoolio.SchoolService.SchoolService.entities._Class;
import com.Skoolio.SchoolService.SchoolService.repositories.ClassRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClassService {

    _Class createClass(_Class _class);
    List<_Class> findBySchoolId(Integer schoolId);

    List<_Class> getAllClass();

    ResponseEntity<List<String>> getClassNameListForSchool(Integer schoolId);

    ResponseEntity<List<ClassRepository._ClassInfo>> getClassInfoList(Integer schoolId,String admissionClass);
}
