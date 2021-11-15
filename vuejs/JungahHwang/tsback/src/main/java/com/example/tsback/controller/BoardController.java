package com.example.tsback.controller;

import com.example.tsback.entity.Board;
import com.example.tsback.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BoardController {

    @Autowired
    private BoardService service;

    @ResponseBody
    @GetMapping("/lists")
    public List<Board> getLists () throws Exception {
        log.info("getLists(): ");

        return service.list();
    }

    @ResponseBody
    @PostMapping("/register")
    public long postRegister (@RequestBody Board board) throws Exception {
        log.info("postRegister(): " + board);

        service.register(board);

        return board.getBoardNo();
    }

    @ResponseBody
    @GetMapping("/{boardNo}")
    public Board getRead(@PathVariable long boardNo) throws Exception {
        log.info("getRead(): " + boardNo);

        return service.read(boardNo);
    }

    @ResponseBody
    @PostMapping("/modify")
    public long postModify (@RequestBody Board board) throws Exception {
        log.info("postModify(): " + board);

        service.modify(board);

        return board.getBoardNo();
    }

    @ResponseBody
    @DeleteMapping("/{boardNo}")
    public void deleteBoardNo (@PathVariable long boardNo) throws Exception {
        log.info("deleteBoardNo(): " + boardNo);

        service.delete(boardNo);
    }
}
