package com.example.writer.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Main {

    @GetMapping("/")
    public String mainPage(){

        log.info("mainPage()");

        return "/main";
    }


}
