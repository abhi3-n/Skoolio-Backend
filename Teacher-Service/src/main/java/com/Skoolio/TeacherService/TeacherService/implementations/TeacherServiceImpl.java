package com.Skoolio.TeacherService.TeacherService.implementations;

import com.Skoolio.TeacherService.TeacherService.entities.Teacher;
import com.Skoolio.TeacherService.TeacherService.model.AddressDetails;
import com.Skoolio.TeacherService.TeacherService.model.UpdateAddressDetails;
import com.Skoolio.TeacherService.TeacherService.model.login.LoginRequest;
import com.Skoolio.TeacherService.TeacherService.model.login.LoginResponse;
import com.Skoolio.TeacherService.TeacherService.repositories.TeacherRepository;
import com.Skoolio.TeacherService.TeacherService.services.TeacherService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Override
    public List<Teacher> getTeachersWithPendingApproval(Integer schoolId) {
        List<Teacher> list = teacherRepository.findByStatusAndTeacherSchoolDetailsSchoolId("approval pending", schoolId);
        return list;
    }
    @Override
    public void approveTeacher(String teacherId) {
        teacherRepository.updateStatusByTeacherId("active", teacherId);
    }


    @Override
    public ResponseEntity<LoginResponse> teacherLogin(LoginRequest loginRequest) {
        List<String> password = teacherRepository.findPasswordByEmail(loginRequest.getEmail());

        if(password.isEmpty()){
            System.out.println("Email not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if(!password.get(0).equals(loginRequest.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        List<Teacher> teachers = teacherRepository.findByEmail(loginRequest.getEmail());
        teachers.get(0).setPassword(null);
        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponse("Approved","Correct Password.", teachers.get(0)));
    }

    @Override
    public void updateAddress(UpdateAddressDetails updateAddressDetails) {
        teacherRepository.updateAddressByTeacherId(updateAddressDetails.getId(), updateAddressDetails.getAddressLine().toLowerCase(),
                updateAddressDetails.getCity().toLowerCase(), updateAddressDetails.getState().toLowerCase());
    }
}
