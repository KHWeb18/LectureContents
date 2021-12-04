package com.example.FirstProject.repository;

import com.example.FirstProject.entity.RecommendComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendCommentRepository extends JpaRepository<RecommendComment, Long> {
    List<RecommendComment> findByBoardNo(Long boardNo);
}

