package com.example.FirstProject.repository;

import com.example.FirstProject.entity.TogetherComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TogetherCommentRepository extends JpaRepository<TogetherComment, Long> {
    List<TogetherComment> findByBoardNo(Long boardNo);
}

