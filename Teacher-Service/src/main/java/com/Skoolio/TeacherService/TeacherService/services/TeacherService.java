package com.Skoolio.TeacherService.TeacherService.services;

import com.Skoolio.TeacherService.TeacherService.entities.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(Teacher teacher);

    List<Teacher> getTeachersBySchoolId(Integer schoolId);

    Teacher getTeacherById(String teacherId);

}
