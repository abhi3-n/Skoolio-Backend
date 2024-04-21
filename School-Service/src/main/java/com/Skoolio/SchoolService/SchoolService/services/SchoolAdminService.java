package com.Skoolio.SchoolService.SchoolService.services;

import com.Skoolio.SchoolService.SchoolService.entities.SchoolAdministrator;
import com.Skoolio.SchoolService.SchoolService.model.UpdateAddressDetails;
import com.Skoolio.SchoolService.SchoolService.model.login.LoginRequest;
import com.Skoolio.SchoolService.SchoolService.model.login.LoginResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SchoolAdminService {
    SchoolAdministrator createAdmin(SchoolAdministrator schoolAdministrator);

    SchoolAdministrator getAdminById(String adminId);

    List<SchoolAdministrator> getAdminsBySchoolId(Integer schoolId);

    ResponseEntity<LoginResponse> adminLogin(LoginRequest loginRequest);

    void updateAddress(UpdateAddressDetails updateAddressDetails);
}
