package com.example.demo.controller.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ThirdController {

    @GetMapping("/checkBoxTest")
    public String checkBoxTest() {
        log.info("checkBoxTest()");

        return "third/checkBox";
    }

    @GetMapping("/radioTest")
    public String radioTest() {
        log.info("radioTest()");

        return "/third/radio";
    }

    @GetMapping("/formRadioTest")
    public String formRadioTest() {
        log.info("formRadioTest()");

        return "third/formRadio";
    }

    @PostMapping("/test")
    public String test() {
        log.info("test()");

        return "redirect:/fontTest";
    }
    //GetMapping을 쓰면 입력값이 도메인 주소 뒤에 노출되지만
    //PostMapping은 패킷안에 숨겨져 전송되어 보안에 유리하다.

    @GetMapping("/fieldsetLogInTest")
    public String fieldsetLogInTest() {
        log.info("fieldsetLogInTest");

        return "third/fieldsetLogIn";
    }

    @GetMapping("/numberRangeTest")
    public String numberRangeTest() {
        log.info("numberRangeInfo()");

        return "third/numberRange";
    }

    @GetMapping("/optgroupTest")
    public String optgroupTest() {
        log.info("optgroupTest()");

        return "third/optgroup";
    }

    @GetMapping("/buttonTest")
    public String buttonTest() {
        log.info("buttonTest()");

        return "third/button";
    }
}
