package com.Skoolio.SchoolService.SchoolService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassInfoRequest {
    private String schoolId;
    private String admissionClass;
}
