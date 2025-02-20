package com.green.springjpa.school;

import com.green.springjpa.school.model.SchoolGetRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("school")
public class SchoolController {
    private final SchoolService schoolService;

    @GetMapping
    public List<SchoolGetRes> getAll() {
        return schoolService.getAll();
    }
}
