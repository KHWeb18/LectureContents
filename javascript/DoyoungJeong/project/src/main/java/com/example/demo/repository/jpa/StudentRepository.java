package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
