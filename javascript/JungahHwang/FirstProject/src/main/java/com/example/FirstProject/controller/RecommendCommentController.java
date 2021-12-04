package com.example.FirstProject.controller;

import com.example.FirstProject.entity.RecommendComment;
import com.example.FirstProject.request.RecommendCommentDto;
import com.example.FirstProject.service.RecommendCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/recommend/comment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RecommendCommentController {

    @Autowired
    private RecommendCommentService service;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody RecommendCommentDto recommendCommentDto) throws Exception {
        log.info("Comment Register");

        RecommendComment recommendComment = service.add(recommendCommentDto);

        return new ResponseEntity(recommendComment, HttpStatus.OK);
    }

    @GetMapping("/read/{boardNo}")
    public ResponseEntity read(@PathVariable Long boardNo) throws Exception {
        log.info("Comment Read");

        List<RecommendComment> recommendComments = service.read(boardNo);

        return new ResponseEntity(recommendComments, HttpStatus.OK);
    }

    @GetMapping("/read/only/{commentNo}")
    public ResponseEntity readOnly(@PathVariable Long commentNo) throws Exception {
        log.info("Comment Read Only");

        RecommendComment recommendComment =  service.readOnly(commentNo);

        return new ResponseEntity(recommendComment, HttpStatus.OK);
    }

    @PatchMapping("/modify/{commentNo}")
    public ResponseEntity<Void> modify(@PathVariable Long commentNo, @RequestBody RecommendCommentDto recommendCommentDto) throws Exception {
        log.info("Comment Modify");

        RecommendComment recommendComment = service.readOnly(commentNo);

        service.modify(recommendComment, recommendCommentDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{commentNo}")
    public ResponseEntity<Void> remove(@PathVariable Long commentNo) throws Exception {
        log.info("Comment Remove");

        RecommendComment recommendComment = service.readOnly(commentNo);

        service.remove(recommendComment);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}


















