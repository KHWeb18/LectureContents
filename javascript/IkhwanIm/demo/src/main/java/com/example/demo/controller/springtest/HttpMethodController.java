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
public class HttpMethodController {

    @GetMapping("/modify")
    public String getMethodModify () throws Exception {
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
        log.info("getMethodLists()");

        return "/httpmethod/lists";
    }

    @GetMapping("/register")
    public String getMethodRegister () {
        log.info("getMethodRegister()");

        return "/httpmethod/register";
    }

    // MVC(Model View Controller) Pattern
    // Model: 다루는 데이터
    // View: 눈에 보이는 화면
    // Controller: URL 제어
    @PostMapping("/register")
    public String postMethodRegister (){
        log.info("postMethodRegister()");

        return "/httpmethod/register";
    }

    @GetMapping("/read/{boardNo}")
    public String getBoardRead (@PathVariable("boardNo") int boardNo) {
        log.info("getBoardRead()" + boardNo);

        return "httpmethod/read";
    }

    @PostMapping("/getBoardRemove")
    public String postMethodRemove () {
        log.info("postMethodRemove()");


        return "httpmethod/remove";
    }
}