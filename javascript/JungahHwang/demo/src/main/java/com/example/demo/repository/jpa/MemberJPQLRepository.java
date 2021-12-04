package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.MemberJPQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberJPQLRepository extends JpaRepository<MemberJPQL, Long> {

    // jpql : join column을 대체할 수 있음
    // mem은 MemberJPQL entity를 나타내는 변수
    @Query("select mem from MemberJPQL mem where mem.id like %?1%")
    List<MemberJPQL> findByJPQL(String id);

    // 현재 JPA 버전에서 JPQL 사용 시 클래스 변수 명명법을 적용해서 표기하도록 해야 함
    // ex) db에서 member_no, 클래스에서 memberNo를 사용하면 memberNo를 사용
    @Query("select mem.memberNo, mem.pw from MemberJPQL mem where mem.id like %:id%")
    List<Object[]> findSpecificJPQL(@Param("id") String id);
}


















