package com.example.project1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller

public class PageController {

    @GetMapping("/getNavigationBarTest")
    public String getNavigationBarTest (){
        log.info("getNavigationBarTest()");

        return "/page/navigationBarTest";
    }


    @GetMapping("/bootStrapTest")
    public String getBootStrapTest (){
        log.info("getBootStrapTest()");

        return "/page/bootStrap";
    }

}
