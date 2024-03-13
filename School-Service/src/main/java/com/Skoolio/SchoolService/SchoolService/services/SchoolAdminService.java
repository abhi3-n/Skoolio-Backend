package com.Skoolio.SchoolService.SchoolService.services;

import com.Skoolio.SchoolService.SchoolService.entities.SchoolAdministrator;

import java.util.List;

public interface SchoolAdminService {
    SchoolAdministrator createAdmin(SchoolAdministrator schoolAdministrator);

    SchoolAdministrator getAdminById(String adminId);

    List<SchoolAdministrator> getAdminsBySchoolId(Integer schoolId);
}
