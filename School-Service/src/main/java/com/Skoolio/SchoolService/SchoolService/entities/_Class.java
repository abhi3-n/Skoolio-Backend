package com.Skoolio.SchoolService.SchoolService.entities;

import com.Skoolio.SchoolService.SchoolService.utils.UniqueIdGenerator;
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
@Table(name = "_class")
public class _Class {
    @Id
    private String classId;
    @Column(nullable = false)
    private String grade;
    private String section;
    private String classTeacherId;
    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private School schoolId;

    public void toLowerCase() {
        this.grade = this.grade.toLowerCase();
        this.section = this.section.toLowerCase();
    }

    public void genClassId(){
        this.classId = UniqueIdGenerator.generateClassId(this.schoolId.getSchoolId().toString() +
                this.grade +
                this.section);
    }
}
