package com.Skoolio.ClassService.ClassService.implementation;

import com.Skoolio.ClassService.ClassService.entities.Attendance;
import com.Skoolio.ClassService.ClassService.repositories.AttendanceRepository;
import com.Skoolio.ClassService.ClassService.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;


    @Override
    public void submitAttendance(List<Attendance> list) {
        for(Attendance attendance:list){
            attendance.genAttId();
            attendanceRepository.save(attendance);
        }
    }
}
