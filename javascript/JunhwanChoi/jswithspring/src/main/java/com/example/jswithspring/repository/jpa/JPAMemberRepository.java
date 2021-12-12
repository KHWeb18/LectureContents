package com.example.jswithspring.repository.jpa;

import com.example.jswithspring.entity.jpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JPAMemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m join fetch m.authList where m.memberNo = :memberNo")
    Optional<Member> findByAuth(Long memberNo);

    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findByUserId(String userId);
}