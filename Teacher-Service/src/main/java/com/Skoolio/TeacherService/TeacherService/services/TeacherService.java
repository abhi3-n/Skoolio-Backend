package com.Skoolio.TeacherService.TeacherService.services;

import com.Skoolio.TeacherService.TeacherService.entities.Teacher;
import com.Skoolio.TeacherService.TeacherService.model.UpdateAddressDetails;
import com.Skoolio.TeacherService.TeacherService.model.login.LoginRequest;
import com.Skoolio.TeacherService.TeacherService.model.login.LoginResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(Teacher teacher);

    List<Teacher> getTeachersBySchoolId(Integer schoolId);

    Teacher getTeacherById(String teacherId);

    List<Teacher> getTeachersWithPendingApproval(Integer schoolId);

    void approveTeacher(String teacherId);

    ResponseEntity<LoginResponse> teacherLogin(LoginRequest loginRequest);

    void updateAddress(UpdateAddressDetails updateAddressDetails);
}
