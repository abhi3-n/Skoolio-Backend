package com.Skoolio.ClassService.ClassService.implementation;

import com.Skoolio.ClassService.ClassService.entities.Attendance;
import com.Skoolio.ClassService.ClassService.repositories.AttendanceRepository;
import com.Skoolio.ClassService.ClassService.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;


    @Override
    public ResponseEntity<?> submitAttendance(List<Attendance> list) {
        HashMap<String, String> response = new HashMap<>();
        try {
            for (Attendance attendance : list) {
                attendance.genAttId();
                attendanceRepository.save(attendance);
            }
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response.put("status","unsuccessful"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.put("status","successful"));
    }
}
