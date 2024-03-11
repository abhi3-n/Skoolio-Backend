package com.Skoolio.SchoolService.SchoolService.repositories;

import com.Skoolio.SchoolService.SchoolService.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
