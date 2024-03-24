package com.Skoolio.ClassService.ClassService.services;

import com.Skoolio.ClassService.ClassService.entities.Attendance;

import java.util.List;

public interface AttendanceService {
    void submitAttendance(List<Attendance> list);
}
