package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Comment;
import com.example.FirstProject.request.CommentDto;
import com.example.FirstProject.service.CommentService;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
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

    @GetMapping("/read/only/{commentNo}")
    public ResponseEntity readOnly(@PathVariable Long commentNo) throws Exception {
        Comment comment =  service.findByCommentNo(commentNo);

        return new ResponseEntity(comment, HttpStatus.OK);
    }

    @PatchMapping("/modify/{commentNo}")
    public ResponseEntity<Void> modify(@PathVariable Long commentNo, @RequestBody CommentDto commentDto) throws Exception {
        log.info("Modify Comment");
        Comment comment = service.findByCommentNo(commentNo);

        service.modify(comment, commentDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{commentNo}")
    public ResponseEntity<Void> remove(@PathVariable Long commentNo) throws Exception {
        Comment comment = service.findByCommentNo(commentNo);

        service.remove(comment);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}


















