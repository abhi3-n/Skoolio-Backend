package com.Skoolio.StudentService.StudentSerivce.implementation;

import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import com.Skoolio.StudentService.StudentSerivce.model.login.LoginRequest;
import com.Skoolio.StudentService.StudentSerivce.model.login.LoginResponse;
import com.Skoolio.StudentService.StudentSerivce.repositories.StudentRepository;
import com.Skoolio.StudentService.StudentSerivce.services.StudentService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student createStudent(Student student) {
        student.readyStudent();
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String studentId) {
        return studentRepository.findById(studentId).orElseThrow(()->
                new ResourceNotFoundException("Requested Student Id not found" + studentId));
    }

    @Override
    public List<Student> getStudentsByClassId(String classId) {
        List<Student> listOfStudents= studentRepository.findByStudentSchoolDetailsClassId(classId);
        return listOfStudents;
    }

    @Override
    public ResponseEntity<LoginResponse> studentLogin(LoginRequest loginRequest) {

        return null;
    }

    @Override
    public List<Student> getStudentsWithPendingApproval(Integer schoolId) {
        List<Student> list = studentRepository.findByStatusAndStudentSchoolDetailsSchoolId("approval pending", schoolId);
        return list;
    }

    @Override
    public void approveStudent(String studentId) {
        studentRepository.updateStatusByStudentId("active", studentId);
    }
}
