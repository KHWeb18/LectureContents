//package com.example.demo.controller.practiceController;
//
//
//import com.example.demo.entity.Board;
//import com.example.demo.service.PracticeService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@Controller
//public class PracticeController {
//    @Autowired
//    PracticeService service;
//
//    @PostMapping("/register")
//    public ResponseEntity<Board> registerBoard(Board board) throws Exception {
//        log.info("board register" + board);
//
//        service.register(board);
//
//        return new ResponseEntity<>(board, HttpStatus.OK);
//    }
//
//    @GetMapping("/list")
//    public ResponseEntity<List<Board>> listBoard() throws Exception {
//        log.info("board list()");
//
//        return new ResponseEntity<>(service.list(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{boardNo}")
//    public ResponseEntity<Board> readBoard(@PathVariable("boardNo") Integer boardNo,
//                                           @Validated @RequestBody Board board) throws Exception {
//        log.info("readBoard ()");
//
//        service.read(boardNo);
//
//        return new ResponseEntity<Board>(board, HttpStatus.OK);
//    }
//
//    @PutMapping("/{boardNo}")
//    public ResponseEntity<Void> modifyBoard(@Validated @RequestBody Board board,
//                                            @PathVariable("boardNo") Integer boardNo) throws Exception {
//        log.info("modifybaordNo : " + boardNo + "boardContent : " + board);
//
//        board.setBoardNo(boardNo);
//
//        service.modify(board);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{boardNo}")
//    public ResponseEntity<Void> deleteBoard(@PathVariable("boardNo") Integer boardNo) throws Exception {
//        log.info("delete boardNo : " + boardNo);
//
//        service.delete(boardNo);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//
//    }
//}
