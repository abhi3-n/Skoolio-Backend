package com.Skoolio.ClassService.ClassService.repositories;

import com.Skoolio.ClassService.ClassService.entities.Attendance;
import com.Skoolio.ClassService.ClassService.entities.AttendanceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, AttendanceId> {
}
