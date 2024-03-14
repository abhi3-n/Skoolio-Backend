package com.Skoolio.TeacherService.TeacherService.repositories;

import com.Skoolio.TeacherService.TeacherService.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,String> {

    List<Teacher> findByTeacherSchoolDetailsSchoolId(Integer classId);

}
