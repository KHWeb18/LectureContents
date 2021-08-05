package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.StudentGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGradeRepository extends JpaRepository<StudentGrade, Long> {

}
