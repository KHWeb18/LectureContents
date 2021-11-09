package com.example.Mini.controller.board;

import com.example.Mini.entity.board.Notice;
import com.example.Mini.service.board.NoticeBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/noticeboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class NoticeBoardController {

    @Autowired
    private NoticeBoardService service;

    @PostMapping("/register")
    public ResponseEntity<Notice> register(@Validated @RequestBody Notice board) throws Exception {
        log.info("post register request from vue");

        service.register(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Notice>> getLists () throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{boardNo}")
    public ResponseEntity<Notice> read(@PathVariable("boardNo") Integer boardNo) throws Exception {
        Notice board = service.read(boardNo);

        return new ResponseEntity<Notice>(board, HttpStatus.OK);
    }

    @PutMapping ("/{boardNo}")
    public ResponseEntity<Notice> modify(@PathVariable("boardNo") Integer boardNo,
                                        @Validated @RequestBody Notice board) throws Exception {
        board.setBoardNo(boardNo);
        service.modify(board);

        return new ResponseEntity<Notice>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Integer boardNo) throws Exception {
        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}