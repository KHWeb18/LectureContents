package com.example.demo.controller.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Controller0709HttpMethodMain {

    @GetMapping("/main")
    public  String getMain () {
        log.info("getMain()");

        return "httpmethod/Review0709/main";
    }
}

























