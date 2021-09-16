package com.example.jsmain.repository.jpa;

import com.example.jsmain.entity.jpa.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface JPATestMemberRepository extends JpaRepository<TestMember, Long> {

    @Query("select mem from TestMember mem where mem.userId like %?1%")
    List<TestMember> findByJPQL(String userId);

    /* 현재 JPA 버전에서는 JPQL 사용시 클래스 변수 명명법을 적용해서 표기하도록 한다
     *  대표적인 예 - db 테이블에 member_no의 경우 JPQL에서는 memberNo로 표기하도록 한다.
     * 여기서 select mem <-- 멤은 변수이므로 헷갈리지않을 변수명으로 작성한다.*/

    @Query("select mem.memberNo, mem.password from TestMember mem where mem.userId like %:userId%")
    List<Object[]> findSpecificByJPQL(@Param("userId") String userId);
}