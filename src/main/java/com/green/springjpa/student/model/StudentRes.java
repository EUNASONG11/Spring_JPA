package com.green.springjpa.student.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StudentRes {
    private Long studentId;
    private String name;
    private LocalDateTime createdAt;
}
