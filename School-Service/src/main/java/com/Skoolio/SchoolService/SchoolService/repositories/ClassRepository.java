package com.Skoolio.SchoolService.SchoolService.repositories;

import com.Skoolio.SchoolService.SchoolService.entities._Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRepository extends JpaRepository<_Class, String> {
    List<_Class> findBySchoolIdSchoolId(Integer schoolId);

    @Query(value = "SELECT DISTINCT c.grade FROM _class c WHERE c.school_id = :schoolId", nativeQuery = true)
    List<String> findDistinctClassForSchool(Integer schoolId);


    //gives all the details of class, modify it
    @Query(value = "SELECT c.class_id as classId, c.grade, c.section FROM _class c WHERE c.grade = :grade AND c.school_id = :schoolId", nativeQuery = true)
    List<_ClassInfo> getClassInfoList(String grade, Integer schoolId);
    public static interface _ClassInfo {
        String getClassId();
        String getGrade();
        String getSection();

    }

}
