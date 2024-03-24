package com.Skoolio.ClassService.ClassService.implementation;

import com.Skoolio.ClassService.ClassService.entities._Class;
import com.Skoolio.ClassService.ClassService.repositories.ClassRepository;
import com.Skoolio.ClassService.ClassService.services.ClassService;
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
            for(ClassRepository._ClassInfo i :list){
                System.out.println("class_id - "+i.getClassId()+", grade - "+i.getGrade()+", section - "+ i.getSection());
            }
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
//        for(ClassRepository._ClassInfo _class:list){
//            System.out.println(_class.toString());
//        }
        System.out.println("List is empty for "+schoolId+", grade - " + grade);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
