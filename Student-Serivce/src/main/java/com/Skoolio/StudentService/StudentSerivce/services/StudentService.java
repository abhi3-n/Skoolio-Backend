package com.Skoolio.StudentService.StudentSerivce.services;

import com.Skoolio.StudentService.StudentSerivce.entities.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    Student getStudentById(String studentId);

    List<Student> getStudentsByClassId(String classId);

}
