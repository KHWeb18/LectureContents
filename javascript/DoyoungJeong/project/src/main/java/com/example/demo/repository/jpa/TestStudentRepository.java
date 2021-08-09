package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.TestStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestStudentRepository extends JpaRepository<TestStudent, Long> {

    @Query("select stu from TestStudent stu where stu.studentPw like %?1%")
    List<TestStudent> findByJPQL(String studentPw);

    @Query("select stu.studentNo, stu.studentId from TestStudent stu where stu.studentPw like %:studentPw%")
    List<Object[]> findSpecificByJPQL(@Param("studentPw") String studentPw);
    //db에서 조건에 맞는 TestStudent 객체들을 요청하기 때문에 Object배열로 받아야함.
    
    // TestStudent배열을 반환형으로 하는것과 Object[]로 객체 배열을 반환형으로 하는것의 구체적 차이
}
