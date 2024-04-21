package com.Skoolio.SchoolService.SchoolService.repositories;

import com.Skoolio.SchoolService.SchoolService.entities.SchoolAdministrator;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolAdminRepo extends JpaRepository<SchoolAdministrator,String> {
    List<SchoolAdministrator> findBySchoolIdSchoolId(Integer schoolId);

    List<SchoolAdministrator> findByEmail(String email);

    @Query(value = "SELECT a.password FROM admin a WHERE a.email = :email", nativeQuery = true)
    List<String> findPasswordByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE admin SET address_line = :addressLine, city =:city, state = :state WHERE admin_id = :adminId", nativeQuery = true)
    void updateAddressByAdminId(String adminId, String addressLine, String city, String state);

    @Modifying
    @Transactional
    @Query(value = "UPDATE admin SET primary_contact = :primaryContact, primary_contact_name = :primaryContactName," +
            " alternative_contact = :alternativeContact, alternative_contact_name = :alternativeContactName WHERE admin_id = :adminId", nativeQuery = true)
    void updateContactByAdminId(String adminId, String primaryContact, String primaryContactName,
                                String alternativeContact, String alternativeContactName);
}
