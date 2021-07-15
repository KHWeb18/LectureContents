package com.example.jsmain.controller.javascript;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TwelvethJavaScriptTestController {

    @GetMapping("checkListWithArrayTest")
    public String getCheckListWithArrayTest() {
        log.info("getCheckListWithArrayTest()");

        return "/javascript/twelveth/checkListWithArrayTest";
    }

    @GetMapping("userList")
    public String getUserList() {
        log.info("getUserList()");

        return "/javascript/twelveth/userList";
    }

    @GetMapping("/domTest")
    public String getDomTest() {
        log.info("getDomTest");

        return "/javascript/twelveth/domTest";
    }

    @GetMapping("/domEventTest")
    public String getDomEventTest() {
        log.info("getDomEventTest");

        return "/javascript/twelveth/domEventTest";
    }
}
