package com.Skoolio.ClassService.ClassService.implementation;

import com.Skoolio.ClassService.ClassService.repositories.AttendanceRepository;
import com.Skoolio.ClassService.ClassService.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;


}
