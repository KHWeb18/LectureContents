package com.example.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/css")
public class Home {

    @GetMapping("/movietest")
    public String getMovietest() {
        log.info("getMovietest()");

        return "movietest";
    }

    @GetMapping("/slide")
    public String getSlideTest() {
        log.info("getSlideTest()");

        return "slide";
    }
    @GetMapping("/just")
    public String getJust() {
        log.info("getJust()");

        return "just";
    }
}
