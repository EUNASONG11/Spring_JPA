package com.green.springjpa.dummy;


import com.green.springjpa.entity.School;
import com.green.springjpa.entity.SchoolTypeCode;
import com.green.springjpa.entity.Student;
import com.green.springjpa.entity.StudentGradeTypeCode;
import com.green.springjpa.school.SchoolRepository;
import com.green.springjpa.student.StudentRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Locale;
import java.util.Random;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentDummyGenerator {
    @Autowired private StudentRepository studentRepository;
    @Autowired private SchoolRepository schoolRepository;

    Faker faker = new Faker(new Locale("ko"));

    RandomEnumGenerator<StudentGradeTypeCode> studentGradeTypeCodeRandomEnumGenerator = new RandomEnumGenerator<>(StudentGradeTypeCode.class);

    @Test
    @Rollback(false)
    void generate() {
        //기존 데이터 삭제
        studentRepository.deleteAll();

        List<School> schoolList = schoolRepository.findAll();

        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder(faker.name().lastName());
            sb.append(faker.name().firstName());

            School schoolRandom = schoolList.get(faker.random().nextInt(schoolList.size()));

            Student student = Student.builder()
                    .name(sb.toString())
                    .school(schoolRandom)
                    .gradeTypeCode(studentGradeTypeCodeRandomEnumGenerator.getRandomEnum())
                    .build();
            studentRepository.save(student);
        }
        studentRepository.flush();
    }
}
