package com.Skoolio.TeacherService.TeacherService.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class AddressDetails {
    @Column(nullable = false)
    private String addressLine;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String city;

    @Override
    public String toString() {
        return "AddressDetails{" +
                "residentialAddress='" + addressLine + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
