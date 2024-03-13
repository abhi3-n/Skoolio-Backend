package com.Skoolio.SchoolService.SchoolService.repositories;

import com.Skoolio.SchoolService.SchoolService.entities._Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<_Class, String> {
    List<_Class> findBySchoolIdSchoolId(Integer schoolId);
    //gives all the details of school, need only basic class details
}
