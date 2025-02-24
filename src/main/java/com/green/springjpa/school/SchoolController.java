package com.green.springjpa.school;

import com.green.springjpa.school.model.SchoolGetRes;
import com.green.springjpa.school.model.SchoolPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public String save(@RequestBody SchoolPostReq req) {
        schoolService.save(req);
        log.info("req: {}", req);
        return "등록 완료";
    }
}
