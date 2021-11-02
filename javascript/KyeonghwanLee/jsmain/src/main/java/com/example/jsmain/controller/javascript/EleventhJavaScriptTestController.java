package com.example.jsmain.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller

public class EleventhJavaScriptTestController {

    @GetMapping("/localStringTest")
    public String getLocaleStringTest() {
        log.info("getLocaleStringTest()");

        return "/javascript/eleventh/localeStringTest";
    }
    @GetMapping("/customObjectTest")
    public String customObjectTest() {
        log.info("customObjectTest()");

        return "/javascript/eleventh/customObjectTest";
    }
    @GetMapping("/destDayTest")
    public String getDestDayTest() {
        log.info("getDestDayTest()");

        return "/javascript/eleventh/destDayTest";
    }
    @GetMapping("/bankTest")
    public String getBankTest() {
        log.info("getBankTest()");

        return "/javascript/eleventh/bankTest";
    }
}
