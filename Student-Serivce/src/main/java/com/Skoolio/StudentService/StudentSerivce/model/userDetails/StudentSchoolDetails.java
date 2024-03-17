package com.Skoolio.StudentService.StudentSerivce.model.userDetails;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StudentSchoolDetails {
    @Column(nullable = false)
    private Integer schoolId; //TODO: Need to use school id instead
    @Column(nullable = false)
    private String classId;

    @Override
    public String toString() {
        return "StudentSchoolDetails{" +
                "school='" + schoolId + '\'' +
                ", _class='" + classId + '\'' +
                '}';
    }
}
