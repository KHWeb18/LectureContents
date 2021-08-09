package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JPATestMemberRepository extends JpaRepository<TestMember, Long> {

    // userId를 가진 TestMember를 모두 넘겨라
    // %?1%는 userId에 대응시켜라라는 의미며 mem은 변수로 내가 지정할 수 있다. 하지만 헷갈리지 않게 작성을 하여야 한다.
    // JPQL은 결국
    // findByJPQL은 전체를 가졍괴
    @Query("select mem from TestMember mem where mem.userId like %?1%")
    List<TestMember> findByJPQL(String userId);

    /* 현재 JPA 버전에서는 JPQL 사용시 클래스 변수 명명법을 적용해서 표기하도록 한다
       대표적인 예 - DB 테이블에 member_no의 경우 JPQL에서는 memberNo로 표기하도록 한다.*/
    // findSpecificByJPQL은 특정 부분만 가져오기
    // mem에 있는 memberNo password를 보여달라 요청한 것
    @Query("select mem.memberNo, mem.password from TestMember mem where mem.userId like %:userId%")
    //List<TestMember> findSpecificByJPQL(@Param("userId") String userId);
    List<Object[]> findSpecificByJPQL(@Param("userId") String userId);
}