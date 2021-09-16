package com.example.jsmain.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstController {
    //...
    @GetMapping("/list")
    public String doHtmlList() {
        log.info("doHtmlList()");
        return "first/list";
    }

    @GetMapping("/imageTest")
    public String doImageTest() {
        log.info("doImageTest()");

        return "first/image";
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

    @GetMapping("/firstTableTest1")
    public String firstTableTest1() {
        log.info("firstTableTest1()");

        return "first/tableTest1";
    }

    @GetMapping("/secondTableTest2")
    public String secondTableTest2() {
        log.info("secondTableTest2()");

        return "first/tableTest2";
    }

    @GetMapping("/thirdTableTest3")
    public String thirdTableTest3() {
        log.info("thirdTableTest3()");

        return "first/tableTest3";
    }
}