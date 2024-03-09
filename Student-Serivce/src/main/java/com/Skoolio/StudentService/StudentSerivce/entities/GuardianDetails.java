package com.Skoolio.StudentService.StudentSerivce.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuardianDetails {
    private String relationType;
    private String name;
    private String occupation;
    private String qualification;

    @Override
    public String toString() {
        return "GuardianDetails{" +
                "relationType='" + relationType + '\'' +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}
