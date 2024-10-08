package com.Skoolio.SchoolService.SchoolService.repositories;

import com.Skoolio.SchoolService.SchoolService.entities.SchoolAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolAdminRepo extends JpaRepository<SchoolAdministrator,String> {
    List<SchoolAdministrator> findBySchoolIdSchoolId(Integer schoolId);

    List<SchoolAdministrator> findByEmail(String email);

    @Query(value = "SELECT a.password FROM admin a WHERE a.email = :email", nativeQuery = true)
    List<String> findPasswordByEmail(String email);
}
