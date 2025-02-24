package com.green.springjpa.dummy;

import com.green.springjpa.entity.School;
import com.green.springjpa.entity.SchoolTypeCode;
import com.green.springjpa.school.SchoolRepository;
import com.green.springjpa.student.StudentRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Locale;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SchoolDummyGenerator {
    @Autowired private SchoolRepository schoolRepository;
    @Autowired private StudentRepository studentRepository;

    Faker faker = new Faker(new Locale("ko"));

    RandomEnumGenerator<SchoolTypeCode> schoolTypeCodeGenerator = new RandomEnumGenerator<>(SchoolTypeCode.class);

    @Test
    @Rollback(false)
    void generate() {
        studentRepository.deleteAll();

        schoolRepository.deleteAll();

        for (int i = 1; i <= 100; i++) {
            School school = School.builder()
                    .name(faker.educator().secondarySchool())
                    .schoolTypeCode(schoolTypeCodeGenerator.getRandomEnum())
                    .build();
            schoolRepository.save(school);
        }
        schoolRepository.flush();
    }
}
