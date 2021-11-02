package com.example.jsmain.controller.javascript;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class EleventhJavaScriptTestController {

    @GetMapping("/localeStringTest")
    public String getLocaleStringTest() {
        log.info("getLocaleStringTest()");

        return "/javascript/eleventh/localeStringTest";
    }

    @GetMapping("/customObjectTest")
    public String getCustomObjectTest() {
        log.info("getCustomObjectTest()");

        return "/javascript/eleventh/customObjectTest";
    }

    @GetMapping("/destDayTest")
    public String getDestDayTest () {
        log.info("getDestDayTest()");

        return "/javascript/eleventh/destDayTest";
    }

    @GetMapping("/bankTest")
    public String getBankTest() {
        log.info("getBankTest");

         return "/javascript/eleventh/bankTest";

    }
}
