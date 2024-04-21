package com.Skoolio.TeacherService.TeacherService.repositories;

import com.Skoolio.TeacherService.TeacherService.entities.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,String> {

    List<Teacher> findByTeacherSchoolDetailsSchoolId(Integer classId);

    List<Teacher> findByStatusAndTeacherSchoolDetailsSchoolId(String approvalPending, Integer schoolId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Teacher SET status = :status WHERE teacher_id = :teacherId", nativeQuery = true)
    void updateStatusByTeacherId(String status, String teacherId);

    @Query(value = "SELECT t.password FROM Teacher t WHERE t.email = :email", nativeQuery = true)
    List<String> findPasswordByEmail(String email);

    List<Teacher> findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teacher SET address_line = :addressLine, city =:city, state = :state WHERE teacher_id = :teacherId", nativeQuery = true)
    void updateAddressByTeacherId(String teacherId, String addressLine, String city, String state);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teacher SET primary_contact = :primaryContact, primary_contact_name = :primaryContactName," +
            " alternative_contact = :alternativeContact, alternative_contact_name = :alternativeContactName WHERE teacher_id = :teacherId", nativeQuery = true)
    void updateContactByTeacherId(String teacherId, String primaryContact, String primaryContactName,
                                  String alternativeContact, String alternativeContactName);

    @Query(value = "SELECT t.teacher_id FROM teacher t WHERE t.email = :email", nativeQuery = true)
    List<String> findByEmailId(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teacher SET password = :newPassword WHERE email = :email", nativeQuery = true)
    void updatePasswordByEmail(String email, String newPassword);
}
