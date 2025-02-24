package com.green.springjpa.entity;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student extends UpdatedAt{
    @Id @Tsid
    private Long studentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private StudentGradeTypeCode gradeTypeCode;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

}
