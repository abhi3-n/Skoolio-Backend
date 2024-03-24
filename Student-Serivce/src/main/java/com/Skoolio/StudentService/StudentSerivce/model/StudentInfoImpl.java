package com.Skoolio.StudentService.StudentSerivce.model;


import com.Skoolio.StudentService.StudentSerivce.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoImpl implements StudentRepository.StudentInfo {
    private String studentId;
    private String firstName;
    private String middleName;
    private String lastName;
}
