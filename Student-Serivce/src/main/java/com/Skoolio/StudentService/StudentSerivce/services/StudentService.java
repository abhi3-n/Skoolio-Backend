package com.Skoolio.StudentService.StudentSerivce.services;

import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import com.Skoolio.StudentService.StudentSerivce.model.login.LoginRequest;
import com.Skoolio.StudentService.StudentSerivce.model.login.LoginResponse;
import com.Skoolio.StudentService.StudentSerivce.repositories.StudentRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    Student getStudentById(String studentId);

    List<StudentRepository.StudentInfo> getStudentsByClassId(String classId);

    ResponseEntity<LoginResponse> studentLogin(LoginRequest loginRequest);

    List<Student> getStudentsWithPendingApproval(Integer schoolId);

    void approveStudent(String studentId, String classId);
}
