package com.Skoolio.ClassService.ClassService.repositories;

import com.Skoolio.ClassService.ClassService.entities._Class;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRepository extends JpaRepository<_Class, String> {
    List<_Class> findBySchoolId(Integer schoolId);

    @Query(value = "SELECT * FROM _class c WHERE c.class_teacher_id = :classTeacherId", nativeQuery = true)
    List<_Class> findByClassTeacherId(String classTeacherId);

    @Query(value = "SELECT DISTINCT c.grade FROM _class c WHERE c.school_id = :schoolId", nativeQuery = true)
    List<String> findDistinctClassForSchool(Integer schoolId);

    //gives all the details of class, modify it

    @Query(value = "SELECT c.class_id as classId, c.grade, c.section FROM _class c WHERE c.grade = :grade AND c.school_id = :schoolId", nativeQuery = true)
    List<_ClassInfo> getClassInfoList(String grade, Integer schoolId);

    @Query(value = "SELECT c.class_id as classId, c.grade, c.section FROM _class c WHERE c.class_teacher_id = :classTeacherId", nativeQuery = true)
    List<_ClassInfo> getClassInfoListForClassTeacherId(String classTeacherId);

    @Query(value = "SELECT c.class_id as classId, c.grade, c.section FROM _class c WHERE c.school_id = :schoolId", nativeQuery = true)
    List<_ClassInfo> getClassInfoListForSchoolId(Integer schoolId);

    public static interface _ClassInfo {

        String getClassId();
        String getGrade();
        String getSection();
    }

    @Modifying
    @Transactional
    @Query(value = "UPDATE _class SET class_teacher_id = :classTeacherId WHERE class_id = :classId", nativeQuery = true)
    void updateClassTeacherIdByClassId(String classId, String classTeacherId);

}
