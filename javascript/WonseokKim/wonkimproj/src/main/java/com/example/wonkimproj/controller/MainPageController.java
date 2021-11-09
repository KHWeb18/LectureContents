package com.example.wonkimproj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MainPageController {

    @GetMapping("/mainPage")
    public String getMainPage () {
        log.info("getMainPage()");

        return "/mainpage/mainPage";
    }
}
