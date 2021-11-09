package com.example.demo.controller.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HtmlTestController {

    @GetMapping("/fail")
    public String firstIndex() {
        log.info("firstIndex() 실행");

        return "first/htmlHi";
    }

    @GetMapping("/fontTest")
    public String doFontTest() {
        log.info("doFontTest()");

        return "first/font";
    }

    @GetMapping("/markTest")
    public String doMarkTest() {
        log.info("doMarkTest()");

        return "first/mark";
    }

    @GetMapping("/tableTest")
    public String doTableTest() {
        log.info("doTableTest");

        return "first/tableTest";
    }

    @GetMapping("/tableTest2")
    public String doTableTest2() {
        log.info("doTableTest2");

        return "first/tableTest2";
    }

    @GetMapping("/tableTest3")
    public String doTableTest3() {
        log.info("doTableTest3");

        return "first/tableTest3";
    }
}
