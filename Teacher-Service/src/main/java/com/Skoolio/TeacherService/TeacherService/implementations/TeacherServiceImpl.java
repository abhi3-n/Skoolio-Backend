package com.Skoolio.TeacherService.TeacherService.implementations;

import com.Skoolio.TeacherService.TeacherService.entities.Teacher;
import com.Skoolio.TeacherService.TeacherService.repositories.TeacherRepository;
import com.Skoolio.TeacherService.TeacherService.services.TeacherService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher createTeacher(Teacher teacher) {
        teacher.readyTeacher();
        return teacherRepository.save(teacher);
    }



    @Override
    public List<Teacher> getTeachersBySchoolId(Integer schoolId) {
        return teacherRepository.findByTeacherSchoolDetailsSchoolId(schoolId);
    }

    @Override
    public Teacher getTeacherById(String teacherId) {
        return teacherRepository.findById(teacherId).orElseThrow(()->
                new ResourceNotFoundException("Requested Teacher Id not found" + teacherId));
    }
}
