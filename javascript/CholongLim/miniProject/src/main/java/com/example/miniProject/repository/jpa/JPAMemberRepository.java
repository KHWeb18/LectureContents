package com.example.miniProject.repository.jpa;

import com.example.miniProject.controller.member.request.UserRequest;
import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.entity.jpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JPAMemberRepository extends JpaRepository<Member, Long> {


    // 아이디 중복 검사
    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findByDuplicateCheck(String userId);

//    @Query("select m from Member m where m.userId = :userId")
//    Optional<Member> findByUserId(String userId);

    @Query("select m.memberNo, m.userPhone, m.userName from Member m where m.userId = :userId")
    List<UserRequest> findByUserInfo(String userId);

    @Query("select m.userName from Member m where m.userId = :userId")
    String findByUserName(String userId);


    List<Member> findByUserId(String userId);
//
//    @Query("select m.memberNo, m.userName, m.userPhone form member where m.userId = :userId")
//    Optional<Member> findByUserInfo(String userId);


    @Query("select m from Member m join fetch m.authList where m.memberNo = :memberNo")
    Optional<Member> findByAuth(Long memberNo);
}