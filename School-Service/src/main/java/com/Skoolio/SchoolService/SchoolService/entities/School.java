package com.Skoolio.SchoolService.SchoolService.entities;

//import com.Skoolio.SchoolService.SchoolService.model.AddressDetails;
import com.Skoolio.SchoolService.SchoolService.model.AddressDetails;
import com.Skoolio.SchoolService.SchoolService.model.SchoolContactDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "school_id_generator")
    @TableGenerator(name = "school_id_generator", table = "id_generator", pkColumnName = "id_name", valueColumnName = "id_value", allocationSize = 1)
    private Integer schoolId;
    @Column(nullable = false)
    private String schoolName;
    @Embedded
    private AddressDetails addressDetails;
    @Embedded
    private SchoolContactDetails schoolContactDetails;
    @Column(nullable = false)
    private Long registrationDate;
    @Column(nullable = false)
    private String schoolActiveStatus;


    public void toLowerCase(){
        this.schoolName = this.schoolName.toLowerCase();
        this.addressDetails.setAddressLine(this.addressDetails.getAddressLine().toLowerCase());
        this.addressDetails.setCity(this.addressDetails.getCity().toLowerCase());
        this.addressDetails.setState(this.addressDetails.getState().toLowerCase());
    }
}
