package com.Skoolio.ClassService.ClassService.model;

import com.Skoolio.ClassService.ClassService.repositories.ClassRepository;
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
    private String section;

    @Override
    public String toString() {
        return "ClassInfoImpl{" +
                "classId='" + classId + '\'' +
                ", grade='" + grade + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}
