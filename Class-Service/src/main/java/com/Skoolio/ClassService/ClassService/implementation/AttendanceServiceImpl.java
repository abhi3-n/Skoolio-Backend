package com.Skoolio.ClassService.ClassService.implementation;

import com.Skoolio.ClassService.ClassService.entities.Attendance;
import com.Skoolio.ClassService.ClassService.repositories.AttendanceRepository;
import com.Skoolio.ClassService.ClassService.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    public List<Attendance> getAttendanceListForRange(Long start, Long end, String studentId) {
        System.out.println(convert(start*1000));
        List<Attendance> list = attendanceRepository.findByDateBetweenAndStudentId(start, end, studentId);
        if(list.isEmpty()){
            System.out.println("attendance list size between and is - "+list.size());
            Attendance attendance = new Attendance("",0L,"","",'\0',"",'\0');
            list.add(attendance);
        }
        return list;
    }
    public String convert(long epochMilli) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
        Date date = new Date(epochMilli);
        return formatter.format(date);
    }
}
