package com.Skoolio.StudentService.StudentSerivce.repositories;

import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {
    List<Student> findByStudentSchoolDetailsClassId(String classId);

    List<Student> findByStatusAndStudentSchoolDetailsSchoolId(String status, Integer schoolId);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Student SET status = :status WHERE student_id = :studentId", nativeQuery = true)
    void updateStatusByStudentId(String status, String studentId);

    @Query(value = "SELECT s.password FROM Student s WHERE s.email = :email", nativeQuery = true)
    List<String> findPasswordByEmail(String email);


    List<Student> findByEmail(String email);
}
