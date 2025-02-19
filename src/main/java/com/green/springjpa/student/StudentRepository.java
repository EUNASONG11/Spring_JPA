package com.green.springjpa.student;

import com.green.springjpa.entity.Student;
import com.green.springjpa.student.model.StudentRes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT new com.green.springjpa.student.model.StudentRes(s.studentId, s.name, s.createdAt)FROM Student s")
    List<StudentRes> findList(Pageable pageable);
}
