package com.green.springjpa.dummy;

import com.green.springjpa.entity.Student;
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
public class StudentDummyGenerator {
    @Autowired
    private StudentRepository studentRepository;

    Faker faker = new Faker(new Locale("ko"));

    @Test
    @Rollback(false)
    void generate() {
        for (int i = 0; i < 10000; i++) {
            StringBuilder sb = new StringBuilder(faker.name().lastName());
            sb.append(faker.name().firstName());

            Student student = Student.builder()
                    .name(sb.toString())
                    .build();
            studentRepository.save(student);
        }
        studentRepository.flush();
    }
}
