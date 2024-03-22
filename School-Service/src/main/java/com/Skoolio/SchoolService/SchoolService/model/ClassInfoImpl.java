package com.Skoolio.SchoolService.SchoolService.model;

import com.Skoolio.SchoolService.SchoolService.repositories.ClassRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassInfoImpl implements ClassRepository._ClassInfo {
    private String classId;
    private String grade;
}
