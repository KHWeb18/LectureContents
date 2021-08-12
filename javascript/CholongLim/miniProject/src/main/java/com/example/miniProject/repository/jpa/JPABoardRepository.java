package com.example.miniProject.repository.jpa;

import com.example.miniProject.entity.jpa.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPABoardRepository extends JpaRepository<Board, Long> {

    // 게시판 검색기능 가능
//    @Query("select m from Member m where m.userId = :userId")
//    Optional<Member> findByUserId(String userId);
}