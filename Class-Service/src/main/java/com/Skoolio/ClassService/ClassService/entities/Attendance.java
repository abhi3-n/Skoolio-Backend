package com.Skoolio.ClassService.ClassService.entities;


import com.Skoolio.ClassService.ClassService.utils.UniqueIdGenerator;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Attendance {
//    @EmbeddedId
//    private AttendanceId id;
    @Id
    private String attendanceId;
    private Long date;
    private String studentId;
    private String classId;
    private Character isPresent;
    private String takenBy;
    private Character takerType; //Admin or Teacher


    public void genAttId(){
        this.attendanceId = UniqueIdGenerator.generateUniqueId(this.date.toString() + this.studentId + this.classId);
    }

}
