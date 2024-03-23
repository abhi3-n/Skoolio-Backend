package com.Skoolio.SchoolService.SchoolService.implementation;

import com.Skoolio.SchoolService.SchoolService.entities.SchoolAdministrator;
import com.Skoolio.SchoolService.SchoolService.model.login.LoginRequest;
import com.Skoolio.SchoolService.SchoolService.model.login.LoginResponse;
import com.Skoolio.SchoolService.SchoolService.repositories.SchoolAdminRepo;
import com.Skoolio.SchoolService.SchoolService.services.SchoolAdminService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolAdminServiceImpl implements SchoolAdminService {
    @Autowired
    private SchoolAdminRepo schoolAdminRepo;

    @Override
    public SchoolAdministrator createAdmin(SchoolAdministrator schoolAdministrator) {
        schoolAdministrator.genAdminId();
        schoolAdministrator.setAdminStatus("active");
        schoolAdministrator.toLowerCase();
        return schoolAdminRepo.save(schoolAdministrator);
    }

    @Override
    public SchoolAdministrator getAdminById(String adminId) {
        return schoolAdminRepo.findById(adminId).orElseThrow(()-> new ResourceNotFoundException("Requested Admin Id not found" + adminId));
    }

    @Override
    public List<SchoolAdministrator> getAdminsBySchoolId(Integer schoolId) {
        return schoolAdminRepo.findBySchoolIdSchoolId(schoolId);
    }

    @Override
    public ResponseEntity<LoginResponse> adminLogin(LoginRequest loginRequest) {
        List<String> password = schoolAdminRepo.findPasswordByEmail(loginRequest.getEmail());

        if(password.isEmpty()){
            System.out.println("Email not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if(!password.get(0).equals(loginRequest.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        List<SchoolAdministrator> schoolAdministrator = schoolAdminRepo.findByEmail(loginRequest.getEmail());
        schoolAdministrator.get(0).setPassword(null);
        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponse("Approved","Correct Password.", schoolAdministrator.get(0)));
    }
}
