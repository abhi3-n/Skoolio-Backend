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

    @Modifying
    @Transactional
    @Query(value = "UPDATE Student SET address_line = :addressLine, city =:city, state = :state WHERE student_id = :studentId", nativeQuery = true)
    void updateAddressByStudentId(String studentId, String addressLine, String city, String state);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Student SET primary_contact = :primaryContact, primary_contact_name = :primaryContactName, primary_contact_relation = :primaryContactRelation," +
            " alternative_contact = :alternativeContact, alternative_contact_name = :alternativeContactName, alternative_contact_relation = :alternativeContactRelation WHERE student_id = :studentId", nativeQuery = true)
    void updateContactByStudentId(String studentId, String primaryContact, String primaryContactName, String primaryContactRelation,
                                  String alternativeContact, String alternativeContactName, String alternativeContactRelation);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Student SET password = :newPassword WHERE email = :email", nativeQuery = true)
    void updatePasswordByEmail(String email, String newPassword);


    @Query(value = "SELECT s.password FROM Student s WHERE s.email = :email", nativeQuery = true)
    List<String> findPasswordByEmail(String email);

    List<Student> findByEmail(String email);

    List<Student> findByStudentSchoolDetailsClassId(String classId);


    @Query(value = "SELECT s.student_id as studentId, s.first_name as firstName, s.middle_name as middleName, s.last_name as lastName FROM student s WHERE s.class_id = :classId", nativeQuery = true)
    List<StudentInfo> findByClassId(String classId);

    @Query(value = "SELECT s.student_id FROM student s WHERE s.email = :email", nativeQuery = true)
    List<String> findByEmailId(String email);

    public static interface StudentInfo {
        String getStudentId();
        String getFirstName();
        String getMiddleName();
        String getLastName();
    }
    @Query(value = "SELECT CONCAT(first_name, ' ', middle_name, ' ' ,last_name) FROM student WHERE student_id = :studentId", nativeQuery = true)
    String findNameByStudentId(String studentId);
}
