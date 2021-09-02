package com.example.FirstProject.service;

import com.example.FirstProject.entity.Comment;
import com.example.FirstProject.repository.CommentRepository;
import com.example.FirstProject.request.CommentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void modify(Comment comment, CommentDto commentDto) throws Exception {
        comment.modify(commentDto);
    }

//    @Override
//    public void remove(Long commentNo) throws Exception {
//        repository.delete(commentNo);
//    }
}
