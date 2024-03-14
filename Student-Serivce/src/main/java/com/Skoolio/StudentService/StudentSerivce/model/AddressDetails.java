package com.Skoolio.StudentService.StudentSerivce.model;


import jakarta.persistence.Embeddable;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class AddressDetails {
    private String addressLine;
    private String state;
    private String city;
    //TODO:pincode?
    @Override
    public String toString() {
        return "AddressDetails{" +
                "residentialAddress='" + addressLine + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
