package com.green.springjpa.school;

import com.green.springjpa.entity.School;
import com.green.springjpa.school.model.SchoolGetRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public List<SchoolGetRes> getAll() {
        List<School> schoolList = schoolRepository.findAll();
        return schoolList.stream() // schoolList 데이터를 가지고 있는 stream 생성
                .map(item -> new SchoolGetRes(item.getSchoolId(), item.getName(), item.getSchoolTypeCode())) //map은 똑같은 크기의 다른 stream 생성
                .toList(); // 새롭게 만들어진 stream을 List를 상속 받은 객체로 Converting
    }
}
