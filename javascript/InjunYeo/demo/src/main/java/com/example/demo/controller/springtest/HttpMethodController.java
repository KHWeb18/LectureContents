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

@Controller
@Slf4j
@RequestMapping("/http-method")

public class HttpMethodController {

    //get방식은 ?가 나온뒤 파라미터를 입력해준다.
    //post는 물음표를 사용하지않는다.

    @Autowired
    private BoardService service;

    @GetMapping("/lists")
    public String getMethodLists() {
        log.info("getMethodLists()");


        return "/httpmethod/lists";
    }

    @GetMapping("/register")
    public String getMethodRegister(){
        log.info("getMethodRegister()");


        return "/httpmethod/register";
    }


    @PostMapping("/register")
    public String postMethodRegister () {
        log.info("postMethodRegister()");


        return "/httpmethod/register";
    }

    @GetMapping("/modify")
    public String getMethodModify() {
        log.info("getMethodModify()");


        return "/httpmethod/modify";
    }

    @PostMapping("/modify")
    public String postMethodModify() {
        log.info("postMethodModify()");


        return "/httpmethod/modify";
    }


    @GetMapping("/read/{boardNo}")
    public String getBoardRead(@PathVariable("boardNo")int boardNo, Model model){
        log.info("getBoardRead():"+boardNo);



        return "httpmethod/read";

    }

    @PostMapping("/remove")
    public String postMethodRemove() {
        log.info("postMethodRemove()");

        return "httpmethod/success";


    }
}
