package com.example.jswithspring.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstController {

    @GetMapping("/htmlList")
    public String doHtmlList () {
        log.info("doHtmlList()");

        return "first/list";
    }

    @GetMapping("/imageTest")
    public String doImageTest () {
        log.info("doImageTest()");

        return "first/image";
    }

    @GetMapping("/fontTest")
    public String doFontTest () {
        log.info("doFontTest()");

        return "first/font";
    }

    @GetMapping("/markTest")
    public String doMarkTest () {
        log.info("doMarkTest()");

        return "first/mark";
    }

    @GetMapping("/firstTableTest")
    public String firstTableTest () {
        log.info("firstTableTest()");

        return "first/tableTest1";
    }

    @GetMapping("/secondTableTest")
    public String secondTableTest () {
        log.info("secondTableTest()");

        return "first/tableTest2";
    }
}
