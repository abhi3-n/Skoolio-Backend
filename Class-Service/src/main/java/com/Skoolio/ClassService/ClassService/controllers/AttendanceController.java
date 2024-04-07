package com.Skoolio.ClassService.ClassService.controllers;

import com.Skoolio.ClassService.ClassService.entities.Attendance;
import com.Skoolio.ClassService.ClassService.services.AttendanceService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    @Operation(summary = "This endpoint is used to submit attendance entries")
    public ResponseEntity<?> submitAttendance(@RequestBody List<Attendance> list){
        return attendanceService.submitAttendance(list);
    }
    @GetMapping("range/{start}/{end}/{studentId}")
    @Operation(summary = "This endpoint is used to get attendance in a range of dates")
    public ResponseEntity<List<Attendance>> getAttendanceListForRange(@PathVariable String start ,@PathVariable String end,@PathVariable String studentId){
        List<Attendance> listOfAttendance = attendanceService.getAttendanceListForRange(Long.parseLong(start),Long.parseLong(end), studentId);
        return ResponseEntity.status(HttpStatus.OK).body(listOfAttendance);
    }

}
