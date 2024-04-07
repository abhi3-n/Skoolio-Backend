package com.Skoolio.ClassService.ClassService.repositories;

import com.Skoolio.ClassService.ClassService.entities.Attendance;
import com.Skoolio.ClassService.ClassService.entities.AttendanceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, AttendanceId> {
    Attendance save(Attendance attendance);

    @Query(value ="SELECT * FROM attendance WHERE date BETWEEN :start AND :end AND student_id = :studentId" , nativeQuery = true)
    List<Attendance> findByDateBetweenAndStudentId(Long start, Long end, String studentId);
}
