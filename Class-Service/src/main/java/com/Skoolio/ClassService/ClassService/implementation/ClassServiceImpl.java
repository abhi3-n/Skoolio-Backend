package com.Skoolio.ClassService.ClassService.implementation;

import com.Skoolio.ClassService.ClassService.entities._Class;
import com.Skoolio.ClassService.ClassService.repositories.ClassRepository;
import com.Skoolio.ClassService.ClassService.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepository classRepository;
    @Override
    public _Class createClass(_Class _class) {
        _class.genClassId();
        return classRepository.save(_class);
    }

    @Override
    public List<_Class> findByClassTeacherId(String classTeacherId) {
        List<_Class> listOfClasses = classRepository.findByClassTeacherId(classTeacherId);
        for (_Class _class:listOfClasses){
            System.out.println(_class.getGrade()+" "+_class.getSection());
        }
        return listOfClasses;
    }

    @Override
    public ResponseEntity<List<ClassRepository._ClassInfo>> getClassInfoListForTeacherId(String classTeacherId) {
        List<ClassRepository._ClassInfo> list =  classRepository.getClassInfoListForClassTeacherId(classTeacherId);

        if(!list.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public List<ClassRepository._ClassInfo> findClassInfoBySchoolId(Integer schoolId) {
        return classRepository.getClassInfoListForSchoolId(schoolId);
    }

    @Override
    public List<_Class> findBySchoolId(Integer schoolId) {
        return classRepository.findBySchoolId(schoolId);
    }

    @Override
    public List<_Class> getAllClass() {
        return classRepository.findAll();
    }

    @Override
    public ResponseEntity<List<String>> getClassNameListForSchool(Integer schoolId) {
        List<String> listOfClasses = classRepository.findDistinctClassForSchool(schoolId);
        if(listOfClasses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        for(String i : listOfClasses){
            System.out.println("grade - "+i);
        }
        return ResponseEntity.status(HttpStatus.OK).body(listOfClasses);
    }

    @Override
    public ResponseEntity<List<ClassRepository._ClassInfo>> getClassInfoList(Integer schoolId,String grade) {
        List<ClassRepository._ClassInfo> list =  classRepository.getClassInfoList(grade, schoolId);

        if(!list.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public ResponseEntity<?> setClassTeacherIdForClass(String classId, String classTeacherId) {
        HashMap<String, String> response = new HashMap<>();
        try {
            classRepository.updateClassTeacherIdByClassId(classId, classTeacherId);
            response.put("status", "successful");
        }
        catch (Exception e){
            response.put("status", "unsuccessful");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
