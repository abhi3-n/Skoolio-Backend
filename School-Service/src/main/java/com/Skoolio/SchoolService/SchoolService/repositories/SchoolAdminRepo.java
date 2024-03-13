package com.Skoolio.SchoolService.SchoolService.repositories;

import com.Skoolio.SchoolService.SchoolService.entities.SchoolAdministrator;
import com.Skoolio.SchoolService.SchoolService.entities._Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolAdminRepo extends JpaRepository<SchoolAdministrator,String> {
    List<SchoolAdministrator> findBySchoolIdSchoolId(Integer schoolId);

}
