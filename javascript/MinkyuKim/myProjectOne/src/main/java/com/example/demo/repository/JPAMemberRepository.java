package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JPAMemberRepository extends JpaRepository<Member, Long> {

    // 조인
    @Query("select m from Member m join fetch m.authList where m.memberNo = :memberNo")
    Optional<Member> findByAuth(Long memberNo);

    // Member 전체를 가져오는데 userId 에 매칭되는 것들을 가져오라는 뜻
    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findByUserId(String userId);
}