package com.example.demo.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TwelvethJavaScriptTestController {

    @GetMapping("/checkListWithArrayTest")
    public String getCheckListWithArrayTest() {
        log.info("getCheckListWithArrayTest()");

        return "/javascript/twelveth/checkListWithArrayTest";
    }

    @GetMapping("/userListTest")
    public String getUserListTest() {
        log.info("getUserListTest()");

        return "/javascript/twelveth/userListTest";
    }

    @GetMapping("/domTest")
    public String getDomTest() {
        log.info("getDomTest()");

        return "/javascript/twelveth/domTest";
    }

    @GetMapping("/domSelfTest")
    public String getDomSelfTest() {
        log.info("getDomSelfTest()");

        return "/javascript/twelveth/domSelfTest";
    }

    @GetMapping("/cssTest")
    public String getCssTest() {
        log.info("getCssTest()");

        return "/javascript/twelveth/cssTest";
    }
}
