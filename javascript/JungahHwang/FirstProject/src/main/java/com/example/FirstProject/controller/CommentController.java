package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Comment;
import com.example.FirstProject.request.CommentDto;
import com.example.FirstProject.service.CommentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody CommentDto commentDto) throws Exception {
        Comment comment = service.add(commentDto);

        return new ResponseEntity(comment, HttpStatus.OK);
    }

    @GetMapping("/read/{boardNo}")
    public ResponseEntity read(@PathVariable Long boardNo) throws Exception {
        List<Comment> commentList = service.findAllComment(boardNo);

        return new ResponseEntity(commentList, HttpStatus.OK);
    }

//    @PatchMapping("/modify/{commentNo}")
//    public ResponseEntity modify(@PathVariable Long commentNo, @RequestBody CommentDto commentDto) throws Exception {
//        Optional<Comment> comment = service.findByCommentNo(commentNo);
//        service.remove(comment);
//
//
//    }

}


















