package com.Skoolio.ClassService.ClassService.services;

import com.Skoolio.ClassService.ClassService.entities._Class;
import com.Skoolio.ClassService.ClassService.repositories.ClassRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClassService {

    _Class createClass(_Class _class);
    List<_Class> findBySchoolId(Integer schoolId);

    List<_Class> getAllClass();

    ResponseEntity<List<String>> getClassNameListForSchool(Integer schoolId);

    ResponseEntity<List<ClassRepository._ClassInfo>> getClassInfoList(Integer schoolId, String admissionClass);

    ResponseEntity<?> setClassTeacherIdForClass(String classId, String classTeacherId);

    List<_Class> findByClassTeacherId(String classTeacherId);
}
