package com.example.FirstProject.service;

import com.example.FirstProject.entity.TogetherComment;
import com.example.FirstProject.request.TogetherCommentDto;

import java.util.List;

public interface TogetherCommentService {
    TogetherComment add(TogetherCommentDto togetherCommentDto) throws Exception;
    List<TogetherComment> read(Long boardNo) throws Exception;
    TogetherComment readOnly(Long commentNo) throws Exception;
    void modify(TogetherComment togetherComment, TogetherCommentDto togetherCommentDto) throws Exception;
    void remove(TogetherComment togetherComment) throws Exception;

}
