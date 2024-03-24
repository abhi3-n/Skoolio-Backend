package com.Skoolio.StudentService.StudentSerivce.repositories;

import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {
    List<Student> findByStatusAndStudentSchoolDetailsSchoolId(String status, Integer schoolId);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Student SET status = :status, class_id =:classId WHERE student_id = :studentId", nativeQuery = true)
    void updateStatusByStudentId(String status, String studentId, String classId);

    @Query(value = "SELECT s.password FROM Student s WHERE s.email = :email", nativeQuery = true)
    List<String> findPasswordByEmail(String email);


    List<Student> findByEmail(String email);

    @Query(value = "SELECT s.student_id as studentId, s.first_name as firstName, s.middle_name as middleName, s.last_name as lastName FROM student s WHERE s.class_id = :classId", nativeQuery = true)
    List<StudentInfo> findByStudentSchoolDetailsClassId(String classId);
    public static interface StudentInfo {
        String getStudentId();
        String getFirstName();
        String getMiddleName();
        String getLastName();

    }
}
