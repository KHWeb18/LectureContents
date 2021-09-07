package com.example.FirstProject.service;

import com.example.FirstProject.entity.Comment;
import com.example.FirstProject.request.CommentDto;

import java.util.List;

public interface CommentService {
    public Comment add(CommentDto commentDto) throws Exception;
    public List<Comment> findAllComment(Long boardNo) throws Exception;
    public Comment findByCommentNo(Long commentNo) throws Exception;
    public void modify(Comment comment, CommentDto commentDto) throws Exception;
    public void remove(Comment comment) throws Exception;
}
