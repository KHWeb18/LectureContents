package com.example.demo.controller.springtest;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/http-method")
// 가변인자 설정하기
public class HttpMethodController {

    @GetMapping("/modify")
    public String getMethodModify () {
        log.info("getMethodModify()");

        return "/httpmethod/modify";
    }

    @PostMapping("/modify")
    public String postMethodModify () {
        log.info("postMethodModify()");

        return "/httpmethod/modify";
    }

    @GetMapping("/lists")
    public String getMethodLists () {
        log.info("getMethodList()");

        return "/httpmethod/lists";
    }

    @GetMapping("/register")
    public String getMethodRegister () {
        log.info("getMethodRegister()");

        return "/httpmethod/register";
    }

    @PostMapping("/register")
    public String postMethodRegister () {
        log.info("postMethodRegister()");

        return "/httpmethod/register";
    }

    // 가변 인자 설정
    // baardNo : 게시물 번호
    // <boardNo} + @PathVariable("boardNo") int boardNo를 통해
    // boardNo으로 들어온 URL에 해당하는 숫자를 boardNo 입력 인자에 저장함
    @GetMapping("/read/{boardNo}")
    public String getBoardRead (@PathVariable("boardNo") int boardNo) {
        log.info("getBoardRead(): " + boardNo);

        return "httpmethod/read";
    }

    @PostMapping("/remove")
    public String postBoardRemove () {
        log.info("postBoardRemove");

        return "httpmethod/remove";
    }
}