package com.example.cholongtest.repository.jpa;

import com.example.cholongtest.entity.jpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JPAMemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m join fetch m.authList where m.memberNo = :memberNo")
    Optional<Member> findByAuth(Long memberNo);

    // 게시판 검색기능 가능
    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findByUserId(String userId);
}