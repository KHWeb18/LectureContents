package com.example.demo.repository.jpa;


import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JPATestMemberRepository extends JpaRepository<TestMember, Long> {

    // mem은 변수이고 아래의 뜻은 mem이 TestMember를 받겠다. 그리고 %?1%은 userId를 매개변수로 한개 받겠다는 뜻
    @Query("select mem from TestMember mem where mem.userId like %?1%")
    List<TestMember> findByJPQL(String userId);

    /* 현재 JPA 버전에서는 JPQL 사용시 클래스 변수 명명법을 적용해서 표기하도록 한다
    * * 대표적인 예 - db 테이블에 member_no의 경유 JPQL 에서는 memberNo로 표기하도록 한다.*/
    @Query("select mem.memberNo, mem.password from TestMember mem where mem.userId like %:userId%")
    List<Object[]> findSpecificByJPQL(@Param("userId") String userId);
}
