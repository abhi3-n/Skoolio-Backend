package com.Skoolio.SchoolService.SchoolService.implementation;

import com.Skoolio.SchoolService.SchoolService.entities.SchoolAdministrator;
import com.Skoolio.SchoolService.SchoolService.repositories.SchoolAdminRepo;
import com.Skoolio.SchoolService.SchoolService.services.SchoolAdminService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolAdminServiceImpl implements SchoolAdminService {
    @Autowired
    private SchoolAdminRepo schoolAdminRepo;

    @Override
    public SchoolAdministrator createAdmin(SchoolAdministrator schoolAdministrator) {
        schoolAdministrator.genAdminId();
        schoolAdministrator.setAdminStatus("active");
        schoolAdministrator.toLowerCase();
        return schoolAdminRepo.save(schoolAdministrator);
    }

    @Override
    public SchoolAdministrator getAdminById(String adminId) {
        return schoolAdminRepo.findById(adminId).orElseThrow(()-> new ResourceNotFoundException("Requested Admin Id not found" + adminId));
    }

    @Override
    public List<SchoolAdministrator> getAdminsBySchoolId(Integer schoolId) {
        return schoolAdminRepo.findBySchoolIdSchoolId(schoolId);
    }
}
