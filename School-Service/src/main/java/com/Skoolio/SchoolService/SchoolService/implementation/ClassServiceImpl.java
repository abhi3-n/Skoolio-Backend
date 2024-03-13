package com.Skoolio.SchoolService.SchoolService.implementation;

import com.Skoolio.SchoolService.SchoolService.entities._Class;
import com.Skoolio.SchoolService.SchoolService.repositories.ClassRepository;
import com.Skoolio.SchoolService.SchoolService.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
