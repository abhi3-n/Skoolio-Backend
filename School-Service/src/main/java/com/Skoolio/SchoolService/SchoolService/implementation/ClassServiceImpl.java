package com.Skoolio.SchoolService.SchoolService.implementation;

import com.Skoolio.SchoolService.SchoolService.entities._Class;
import com.Skoolio.SchoolService.SchoolService.repositories.ClassRepository;
import com.Skoolio.SchoolService.SchoolService.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<_Class> findBySchoolId(Integer schoolId) {
        return classRepository.findBySchoolIdSchoolId(schoolId);
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
}
