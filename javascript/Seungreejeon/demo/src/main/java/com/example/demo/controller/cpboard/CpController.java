package com.example.demo.controller.cpboard;


import com.example.demo.entity.Board;
import com.example.demo.service.CpboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/cpboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CpController {

    @Autowired
    private CpboardService service;

    @GetMapping("/list")
    public ResponseEntity<List<Board>> getList() throws Exception {
        log.info("GETLIST()" + service.list());

        return new ResponseEntity<List<Board>>(service.list(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Board> registration(@Validated @RequestBody Board board) throws Exception {
        log.info("post register request from vue");

        service.register(board);
        return new ResponseEntity<Board>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Integer boardNo) throws Exception {
        log.info("번호"+boardNo);

        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PutMapping("/{boardNo}")
    public ResponseEntity<Board> modify(@PathVariable("boardNo") Integer boardNo,
                                        @Validated @RequestBody Board board) throws Exception {
        log.info("보드정보"+board);
        board.setBoardNo(boardNo);
        service.modify(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

}
