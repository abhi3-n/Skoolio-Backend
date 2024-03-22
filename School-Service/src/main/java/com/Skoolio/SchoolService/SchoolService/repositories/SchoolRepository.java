package com.Skoolio.SchoolService.SchoolService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<com.Skoolio.SchoolService.SchoolService.entities.School, Integer> {


@Query(value = "SELECT s.school_id AS schoolId, s.school_name AS schoolName " +
        "FROM school s WHERE s.city = :city", nativeQuery = true)

List<SchoolInfo> getSchoolsByCity(String city);
    public static interface SchoolInfo {
    Integer getSchoolId();
    String getSchoolName();
    }



    @Query(value = "SELECT DISTINCT s.city FROM school s", nativeQuery = true)
    List<String> findDistinctCity();
}
