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
// 가변인자에 대한 핸들링
public class HttpMethodController {
    @GetMapping("/modify")
    public String getMethodModify () {
        log.info("getMethodModify()") ;

        return "/httpmethod/modify";
    }

    @PostMapping("/modify")
    public String postMethodModify ()  {
        log.info("postMethodModify()");

        return  "/httpmethod/modify";
    }

    @GetMapping("/lists")
    public String getMethodLists ()  {
        log.info("getMethodLists()");

        return "/httpmethod/lists";
    }

    @GetMapping("/register")
    public String getMethodRegister () {
        log.info("getMethodRegister()");

        return "/httpmethod/register";
    }


    @PostMapping("/register")
    public String postMethodRegister ()  {
        log.info("postMethodRegister()");

        return "/httpmethod/register";
    }


    @GetMapping("/read/{boardNo}")
    public String getMethodRead (@PathVariable("boardNo") int boardNo) {
        log.info("getMethodRead()" + boardNo);

        return "/httpmethod/read";
    }

    @PostMapping("/remove")
    public String getMethodRemove ()  {
        log.info("getMethodRemove()");

        return "/httpmethod/remove";

    }
}



