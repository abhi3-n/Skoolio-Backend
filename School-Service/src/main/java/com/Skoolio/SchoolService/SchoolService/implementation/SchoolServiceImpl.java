package com.Skoolio.SchoolService.SchoolService.implementation;

import com.Skoolio.SchoolService.SchoolService.entities.School;
import com.Skoolio.SchoolService.SchoolService.repositories.SchoolRepository;
import com.Skoolio.SchoolService.SchoolService.services.SchoolService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;
    @Override
    public School saveSchool(School school) {
        school.setSchoolActiveStatus("Active");
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchool() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchool(Integer schoolId) {
        return schoolRepository.findById(schoolId).orElseThrow(()-> new ResourceNotFoundException("Requested User Id not found" + schoolId));
    }
}
