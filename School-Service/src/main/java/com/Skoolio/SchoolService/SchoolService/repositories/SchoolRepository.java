package com.Skoolio.SchoolService.SchoolService.repositories;

import com.Skoolio.SchoolService.SchoolService.model.AddressDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<com.Skoolio.SchoolService.SchoolService.entities.School, Integer> {


@Query(value = "SELECT s.school_id AS schoolId, s.school_name AS schoolName, " +
        "s.address_line AS addressLine, s.city AS city, " +
        "s.state AS state, s.pincode AS pincode " +
        "FROM school s WHERE s.city = :city", nativeQuery = true)

List<SchoolInfo> getSchoolsByCity(String city);
    public static interface SchoolInfo {
    Integer getSchoolId();
    String getSchoolName();
        String getAddressLine();
        String getCity();
        String getState();
        String getPincode();
    }
    //    @Query(value = "SELECT s.school_id AS schoolId, s.school_name AS schoolName, s.address_line AS addressDetails.addressLine, s.city AS addressDetails.city, s.state AS addressDetails.state, s.pincode AS addressDetails.pincode FROM school s WHERE s.city = :city", nativeQuery = true)
    //        AddressDetails getAddressDetails();

}
