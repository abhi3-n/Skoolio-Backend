package com.Skoolio.SchoolService.SchoolService.entities;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
public class AdminSchool {
    private String adminId;
    private String schoolId;
}
