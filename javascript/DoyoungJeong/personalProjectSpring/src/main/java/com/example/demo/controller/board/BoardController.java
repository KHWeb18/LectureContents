package com.example.demo.controller.board;

import com.example.demo.controller.board.request.BoardRequest;
import com.example.demo.controller.board.request.ReplyModifyRequest;
import com.example.demo.controller.board.request.ReplyRequest;
import com.example.demo.entity.board.Board;
import com.example.demo.entity.board.BoardReply;
import com.example.demo.service.board.BoardService;
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
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BoardController {

    @Autowired
    BoardService service;

    @PostMapping("/upload")
    public ResponseEntity<Void> upload(@Validated @RequestBody BoardRequest boardRequest) throws Exception {
        log.info("upload(): " + boardRequest);

        service.upload(boardRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Board>> list() throws Exception {
        log.info("getList(): " + service.list());

        List<Board> list = service.list();
        //List<Board> list = null;

        return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
    }

    @GetMapping("/read/{boardNo}")
    public ResponseEntity<Board> read(@PathVariable("boardNo") Integer boardNo) throws Exception {
        log.info("read() - boardNo: " + boardNo);

        Board board = service.read(boardNo);

        return new ResponseEntity<Board>(board, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{boardNo}")
    public ResponseEntity<Void> delete(@PathVariable("boardNo") Integer boardNo) throws Exception {
        log.info("delete() - boardNo: " + boardNo);

        service.delete(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<Void> modify(@Validated @RequestBody BoardRequest boardRequest) throws Exception {
        log.info("modify(): " + boardRequest);

        service.modify(boardRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/addReply")
    public ResponseEntity<Void> addReply(@Validated @RequestBody ReplyRequest replyRequest) throws Exception {
        log.info("addReply(): " + replyRequest);

        service.addReply(replyRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/replyList/{boardNo}")
    public ResponseEntity<List<BoardReply>> replyList(@PathVariable("boardNo") Integer boardNo) throws Exception {
        log.info("replyList() - boardNo: " + boardNo);

        List<BoardReply> replyList = service.replyList(boardNo);

        return new ResponseEntity<List<BoardReply>>(replyList, HttpStatus.OK);
    }

    @DeleteMapping("/deleteReply/{replyNo}")
    public ResponseEntity<Void> replyDelete(@PathVariable("replyNo") Integer replyNo) throws Exception {
        log.info("replyDelete(): " + replyNo);

        service.deleteReply(replyNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/modifyReply")
    public ResponseEntity<Void> modifyReply(@Validated @RequestBody ReplyModifyRequest replyModifyRequest) throws Exception {
        log.info("modifyReply(): " + replyModifyRequest);

        service.modifyReply(replyModifyRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
