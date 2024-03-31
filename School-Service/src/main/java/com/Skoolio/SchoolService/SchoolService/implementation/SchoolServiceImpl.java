package com.Skoolio.SchoolService.SchoolService.implementation;

import com.Skoolio.SchoolService.SchoolService.entities.School;
import com.Skoolio.SchoolService.SchoolService.model.SchoolName;
import com.Skoolio.SchoolService.SchoolService.repositories.SchoolRepository;
import com.Skoolio.SchoolService.SchoolService.services.SchoolService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchool(Integer schoolId) throws InterruptedException {
        System.out.println("Request Made");
        Thread.sleep(3000);
        return schoolRepository.findById(schoolId).orElseThrow(()-> new ResourceNotFoundException("Requested School Id not found" + schoolId));
    }

    @Override
    public List<SchoolRepository.SchoolInfo> getSchoolsByCity(String city) {
        return schoolRepository.getSchoolsByCity(city.toLowerCase());
    }

    @Override
    public ResponseEntity<List<String>> getCitiesList() {
        List<String> cityList = schoolRepository.findDistinctCity();
        if(cityList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(cityList);
    }

    @Override
    public ResponseEntity<SchoolName> getSchoolNameForSchoolId(Integer schoolId) {
        List<String> schoolName = schoolRepository.findSchoolNameBySchoolId(schoolId);
        for(String s: schoolName){
            System.out.println(s);
        }
        if(schoolName.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new SchoolName(schoolName.get(0)));
    }


}
