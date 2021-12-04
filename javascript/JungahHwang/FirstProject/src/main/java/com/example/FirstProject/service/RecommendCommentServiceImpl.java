package com.example.FirstProject.service;

import com.example.FirstProject.entity.RecommendComment;
import com.example.FirstProject.repository.RecommendCommentRepository;
import com.example.FirstProject.request.RecommendCommentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class RecommendCommentServiceImpl implements RecommendCommentService {
    @Autowired
    RecommendCommentRepository repository;

    @Override
    public RecommendComment add(RecommendCommentDto recommendCommentDto) throws Exception {
        RecommendComment recommendComment = repository.save(recommendCommentDto.toEntity());

        return recommendComment;
    }

    @Override
    public List<RecommendComment> read(Long boardNo) throws Exception {
        List<RecommendComment> recommendComments = repository.findByBoardNo(boardNo);

        return recommendComments;
    }

    @Override
    public RecommendComment readOnly(Long commentNo) throws Exception {
        RecommendComment recommendComment = repository.findById(commentNo).orElseThrow();

        return recommendComment;
    }

    @Override
    public void modify(RecommendComment recommendComment, RecommendCommentDto recommendCommentDto) throws Exception {
        recommendComment.updateContent(recommendCommentDto);

        repository.save(recommendComment);
    }

    @Override
    public void remove(RecommendComment recommendComment) throws Exception {
        repository.delete(recommendComment);
    }
}
