package com.example.FirstProject.controller;

import com.example.FirstProject.entity.TogetherComment;
import com.example.FirstProject.request.TogetherCommentDto;
import com.example.FirstProject.service.TogetherCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/together/comment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class TogetherCommentController {

    @Autowired
    private TogetherCommentService service;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody TogetherCommentDto togetherCommentDto) throws Exception {
        log.info("Comment Register");

        TogetherComment togetherComment = service.add(togetherCommentDto);

        return new ResponseEntity(togetherComment, HttpStatus.OK);
    }

    @GetMapping("/read/{boardNo}")
    public ResponseEntity read(@PathVariable Long boardNo) throws Exception {
        log.info("Comment Read");

        List<TogetherComment> togetherCommentList = service.read(boardNo);

        return new ResponseEntity(togetherCommentList, HttpStatus.OK);
    }

    @GetMapping("/read/only/{commentNo}")
    public ResponseEntity readOnly(@PathVariable Long commentNo) throws Exception {
        log.info("Comment Read Only");

        TogetherComment togetherComment =  service.readOnly(commentNo);

        return new ResponseEntity(togetherComment, HttpStatus.OK);
    }

    @PatchMapping("/modify/{commentNo}")
    public ResponseEntity<Void> modify(@PathVariable Long commentNo, @RequestBody TogetherCommentDto togetherCommentDto) throws Exception {
        log.info("Comment Modify");

        TogetherComment togetherComment = service.readOnly(commentNo);

        service.modify(togetherComment, togetherCommentDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{commentNo}")
    public ResponseEntity<Void> remove(@PathVariable Long commentNo) throws Exception {
        log.info("Comment Remove");

        TogetherComment togetherComment = service.readOnly(commentNo);

        service.remove(togetherComment);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}


















