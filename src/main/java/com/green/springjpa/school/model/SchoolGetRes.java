package com.green.springjpa.school.model;

import com.green.springjpa.entity.SchoolTypeCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SchoolGetRes {
    private Long schoolId;
    private String name;
    private SchoolTypeCode schoolType;
}
