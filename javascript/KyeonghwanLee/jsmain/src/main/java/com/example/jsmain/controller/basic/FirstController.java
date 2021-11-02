package com.example.jsmain.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstController {


    @GetMapping("/htmlList")
    public String doHtmlList() {
        log.info("doHtmlList()");

        return "templates/first/list";
    }

    @GetMapping("/imageTest")
    public String doImageTest() {
        log.info("doImageTest()");

        return "templates/first/image";
    }

    @GetMapping("/fontTest")
    public String doFontTest() {
        log.info("doFontTest()");

        return "templates/first/font";

    }

    @GetMapping("/markTest")
    public String doMarkTest() {
        log.info("doMarkTest()");

        return "templates/first/mark";

    }

    @GetMapping("/firstTableTest")
    public String firstTableTest() {
        log.info("firstTableTest()");

        return "templates/first/tableTest";

    }

    @GetMapping("/secondTableTest")
    public String secondTableTest() {
        log.info("secondTableTest()");

        return "templates/first/tableTest2";

    }

    @GetMapping("/thirdTableTest")
    public String thirdTableTest() {
        log.info("thirdTableTest()");

        return "templates/first/tableTest3";

    }

    @GetMapping("/resumeTest")
    public String resumeTest() {
        log.info("resumeTest()");

        return "templates/first/resume";
    }
}