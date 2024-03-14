package com.Skoolio.StudentService.StudentSerivce.repositories;

import com.Skoolio.StudentService.StudentSerivce.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}
