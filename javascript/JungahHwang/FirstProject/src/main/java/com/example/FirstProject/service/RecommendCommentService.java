package com.example.FirstProject.service;

import com.example.FirstProject.entity.RecommendComment;
import com.example.FirstProject.request.RecommendCommentDto;

import java.util.List;

public interface RecommendCommentService {
    RecommendComment add(RecommendCommentDto recommendCommentDto) throws Exception;
    List<RecommendComment> read(Long boardNo) throws Exception;
    RecommendComment readOnly(Long commentNo) throws Exception;
    void modify(RecommendComment recommendComment, RecommendCommentDto recommendCommentDto) throws Exception;
    void remove(RecommendComment recommendComment) throws Exception;

}
