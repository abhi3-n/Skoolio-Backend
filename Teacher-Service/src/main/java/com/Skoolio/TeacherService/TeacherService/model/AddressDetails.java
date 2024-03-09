package com.Skoolio.TeacherService.TeacherService.model;


import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDetails {
    private String residentialAddress;
    private String state;
    private String city;

    @Override
    public String toString() {
        return "AddressDetails{" +
                "residentialAddress='" + residentialAddress + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
