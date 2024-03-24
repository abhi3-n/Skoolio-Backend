package com.Skoolio.ClassService.ClassService.entities;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
    @EmbeddedId
    private AttendanceId id;
    private Boolean isPresent;
    private String takenBy;
    private Character takerType; //Admin or Teacher
}
