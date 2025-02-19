package com.green.springjpa.entity;

import com.green.springjpa.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//JPA Test
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentTest {
    @Autowired //TDD 에서 DI 받을 때는 @Autowired 애노테이션으로 해야 한다.
    private StudentRepository studentRepository;

    @Test
    @Transactional
    public void createStudent() {
        for(int i = 1; i <= 100; i++) {
            Student student = Student.builder()
                    .name(String.format("홍길동%03d", i))
                    .build();
            studentRepository.save(student);
        }
        studentRepository.flush();
    }
}