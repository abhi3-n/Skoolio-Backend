package com.Skoolio.StudentService.StudentSerivce.implementation;

import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import com.Skoolio.StudentService.StudentSerivce.repositories.StudentRepository;
import com.Skoolio.StudentService.StudentSerivce.services.StudentService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
}
