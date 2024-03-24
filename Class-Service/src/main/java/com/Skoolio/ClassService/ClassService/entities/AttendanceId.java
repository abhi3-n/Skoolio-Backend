package com.Skoolio.ClassService.ClassService.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AttendanceId implements Serializable {
    private Long date;
    private String studentId;
    private String classId;

    // Default constructor
    public AttendanceId() {}

    // Constructor with date, studentId, and classId
    public AttendanceId(Long date, String studentId, String classId) {
        this.date = date;
        this.studentId = studentId;
        this.classId = classId;
    }

    // Implement equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceId that = (AttendanceId) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, studentId, classId);
    }

    @Override
    public String toString() {
        return "AttendanceId{" +
                "date=" + date +
                ", studentId='" + studentId + '\'' +
                ", classId='" + classId + '\'' +
                '}';
    }
}
