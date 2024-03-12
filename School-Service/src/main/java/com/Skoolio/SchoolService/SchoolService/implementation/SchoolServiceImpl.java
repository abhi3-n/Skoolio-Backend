package com.Skoolio.SchoolService.SchoolService.implementation;

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
    public com.Skoolio.SchoolService.SchoolService.entities.School saveSchool(com.Skoolio.SchoolService.SchoolService.entities.School school) {
        school.setSchoolActiveStatus("Active");
        return schoolRepository.save(school);
    }

    @Override
    public List<com.Skoolio.SchoolService.SchoolService.entities.School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public com.Skoolio.SchoolService.SchoolService.entities.School getSchool(Integer schoolId) {
        return schoolRepository.findById(schoolId).orElseThrow(()-> new ResourceNotFoundException("Requested School Id not found" + schoolId));
    }

    @Override
    public List<SchoolRepository.SchoolInfo> getSchoolsByCity(String city) {
        return schoolRepository.getSchoolsByCity(city.toLowerCase());
    }
}
