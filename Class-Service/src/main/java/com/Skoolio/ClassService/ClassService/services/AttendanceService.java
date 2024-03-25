package com.Skoolio.ClassService.ClassService.services;

import com.Skoolio.ClassService.ClassService.entities.Attendance;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AttendanceService {
    ResponseEntity<?> submitAttendance(List<Attendance> list);
}
