package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> { //Long형만 들어감 왜 Long형만 들어가는건지?
    @Query("select st from Student st join fetch st.gradeList where st.studentNo = :studentNo")
    Optional<Student> findByStudentNo(@Param("studentNo") Long studentNo);

    @Query("select st from Student st where st.studentId = :studentId")
    Optional<Student> findByStudentId(@Param("studentId")String studentId);

}
