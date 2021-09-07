package com.example.FirstProject.service;

import com.example.FirstProject.entity.Comment;
import com.example.FirstProject.repository.CommentRepository;
import com.example.FirstProject.request.CommentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository repository;

    @Override
    public Comment add(CommentDto commentDto) throws Exception {
        Comment comment = repository.save(commentDto.toEntity());

        return comment;
    }

    @Override
    public List<Comment> findAllComment(Long boardNo) throws Exception {
        List<Comment> comments = repository.findByBoardNo(boardNo);

        return comments;
    }

    @Override
    public Comment findByCommentNo(Long commentNo) throws Exception {
        Comment comment = repository.findById(commentNo).orElseThrow();

        return comment;
    }

    @Override
    public void modify(Comment comment, CommentDto commentDto) throws Exception {
        comment.updateContent(commentDto);

        repository.save(comment);
    }

    @Override
    public void remove(Comment comment) throws Exception {
        repository.delete(comment);
    }
}
