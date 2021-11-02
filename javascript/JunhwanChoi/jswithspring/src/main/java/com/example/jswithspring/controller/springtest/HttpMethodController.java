package com.example.jswithspring.controller.springtest;


import com.example.jswithspring.entity.Board;
import com.example.jswithspring.service.BoardService;
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

    @Autowired
    private BoardService service;

    @GetMapping("/modify")
    public String getMethoddModify () throws Exception {
        log.info("getMethodModify()");

        return "/httpmethod/modify";
    }

    @PostMapping("/modify")
    public String postMethodModify () throws Exception {
        log.info("postMethodModify");

        return "/httpmethod/modify";
    }

    @GetMapping("/lists")
    public String getMethodLists () throws Exception {
        log.info("getMethodLists() ");

        return "/httpmethod/lists";
    }


    @GetMapping("/register")
    public String getMethodRegister () {
        log.info("getMethodRegister()");

        return "/httpmethod/register";
    }

    @PostMapping("/register")
    public String postMethodRegister () throws Exception {
        log.info("postMethodRegister()");


        return "/httpmethod/success";
    }



    @GetMapping("/read/{boardNo}")
    public String getMethodRead (@PathVariable("boardNo") int boardNo) throws Exception {
        log.info("getBoardRead(): " + boardNo);


        return "/httpmethod/read";
    }


    @PostMapping("/remove")
    public String postMethodremove () throws Exception {
        log.info("postMethodremove");

        return "/httpmethod/success";
    }
}
