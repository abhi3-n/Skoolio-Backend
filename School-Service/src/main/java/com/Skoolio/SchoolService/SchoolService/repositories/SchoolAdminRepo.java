package com.Skoolio.SchoolService.SchoolService.repositories;

import com.Skoolio.SchoolService.SchoolService.entities.SchoolAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolAdminRepo extends JpaRepository<SchoolAdministrator,String> {
}
