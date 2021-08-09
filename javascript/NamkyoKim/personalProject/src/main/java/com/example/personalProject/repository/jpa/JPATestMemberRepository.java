package com.example.personalProject.repository.jpa;

import com.example.personalProject.eutity.jpa.Member;
import com.example.personalProject.eutity.jpa.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JPATestMemberRepository extends JpaRepository<TestMember, Long> {

    @Query("select mem from TestMember mem where mem.id like %?1%")
    List<TestMember> findByJPQL(String id);

    /* 현재 JPA 버전에서는 JPQL 사용시 클래스 변수 명명법을 적용해서 표기하도록 한다
    *  대표적인 예 - db 테이블에 member_no의 경우 JPQL에서는 memberNo로 표기한다 */
    @Query("select mem.memberNo, mem.pw from TestMember mem where mem.id like %:id%")
    List<Object[]> findSpecificByJPQL(@Param("id") String id);
}