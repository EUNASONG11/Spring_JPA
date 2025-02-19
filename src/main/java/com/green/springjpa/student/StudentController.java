package com.green.springjpa.student;

import com.green.springjpa.student.model.StudentRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    List<StudentRes> getList(@RequestParam int page, @RequestParam int size) {
        return studentService.getStudentList(PageRequest.of(page, size));
    }

}
