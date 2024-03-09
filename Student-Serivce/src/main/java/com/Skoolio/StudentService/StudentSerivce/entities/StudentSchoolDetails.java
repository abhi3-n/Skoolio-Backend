package com.Skoolio.StudentService.StudentSerivce.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentSchoolDetails {
    private String school; //TODO: Need to use school id instead
    private String _class;
    private String section;

    @Override
    public String toString() {
        return "StudentSchoolDetails{" +
                "school='" + school + '\'' +
                ", _class='" + _class + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}
