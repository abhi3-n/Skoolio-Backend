package com.Skoolio.ClassService.ClassService.entities;

import com.Skoolio.ClassService.ClassService.utils.UniqueIdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(nullable = false)
    private Integer schoolId;
    @Column(nullable = false)
    private Float fees;

    public void toLowerCase() {
        this.grade = this.grade.toLowerCase();
        this.section = this.section.toLowerCase();
    }

    public void genClassId(){
        this.classId = UniqueIdGenerator.generateUniqueId(this.getSchoolId().toString() +
                this.grade +
                this.section);
    }
}
