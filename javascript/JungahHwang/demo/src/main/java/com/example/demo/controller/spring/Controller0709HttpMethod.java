package com.example.demo.controller.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/http-method")
public class Controller0709HttpMethod {

     @GetMapping("/register")
    public String getMethodRegister () {
        log.info("getMethodRegister()");

        return "httpmethod/Review0709/register";
    }

    @PostMapping("/register")
    public String postMethodRegister () {
        log.info("postMethodRegister()");

        return "httpmethod/Review0709/register";
    }

    @GetMapping("/lists")
    public String getMethodLists () {
        log.info("getMethodLists(): ");

        return "httpmethod/Review0709/lists";
    }

    @GetMapping("/read/{boardNo}")
    public String getMethodRead (@PathVariable("boardNo") int boardNo) {
        log.info("getMethodRead(): " + boardNo);

        return "httpmethod/Review0709/read";
    }

    @PostMapping("/remove")
    public String postMethodRemove () {
        log.info("postMethodRemove()");

        return "httpmethod/Review0709/remove";
    }

    @GetMapping("/modify")
    public String getMethodModify() {
        log.info("getMethodModify()");

        return "httpmethod/Review0709/modify";
    }
    @PostMapping("/modify")
    public String postMethodModify() {
        log.info("postMethodModify");

        return "httpmethod/Review0709/modify";
    }
}
