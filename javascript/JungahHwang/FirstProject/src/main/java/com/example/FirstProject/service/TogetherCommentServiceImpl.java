package com.example.FirstProject.service;

import com.example.FirstProject.entity.TogetherComment;
import com.example.FirstProject.repository.TogetherCommentRepository;
import com.example.FirstProject.request.TogetherCommentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class TogetherCommentServiceImpl implements TogetherCommentService {
    @Autowired
    TogetherCommentRepository repository;

    @Override
    public TogetherComment add(TogetherCommentDto togetherCommentDto) throws Exception {
        TogetherComment togetherComment = repository.save(togetherCommentDto.toEntity());

        return togetherComment;
    }

    @Override
    public List<TogetherComment> read(Long boardNo) throws Exception {
        List<TogetherComment> togetherComments = repository.findByBoardNo(boardNo);

        return togetherComments;
    }

    @Override
    public TogetherComment readOnly(Long commentNo) throws Exception {
        TogetherComment togetherComment = repository.findById(commentNo).orElseThrow();

        return togetherComment;
    }

    @Override
    public void modify(TogetherComment togetherComment, TogetherCommentDto togetherCommentDto) throws Exception {
        togetherComment.updateContent(togetherCommentDto);

        repository.save(togetherComment);
    }

    @Override
    public void remove(TogetherComment togetherComment) throws Exception {
        repository.delete(togetherComment);
    }
}
