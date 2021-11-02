package com.example.jswithspring.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class SecondController {

    @GetMapping("/heightWidthTest")
    public String heightWidthTest () {
        log.info("heightWidthTest()");

        return "/second/heightWidthTest";
    }

    @GetMapping("/divTest1")
    public String divTest1 () {
        log.info("divTest1()");

        return "/second/divTest1";
    }

    @GetMapping("/divTest2")
    public String divTest2 () {
        log.info("divTest2()");

        return "/second/divTest2";
    }

    @GetMapping("/divTest3")
    public String divTest3 () {
        log.info("divTest3()");

        return "/second/divTest3";
    }

    @GetMapping("/aTagTest")
    public String aTagTest () {
        log.info("aTagTest()");

        return "/second/aTagTest";
    }

    @GetMapping("/formTest1")
    public String formTest1 () {
        log.info("formTest1");

        return "/second/formTest1";
    }

    // 데이터 전송 포맷은 ? >>> json <<<
    @PostMapping("/memberRegister")
    public String memberRegister () {
        log.info("memberRegister()");

        // redirect: 의 경우 특정한 URL 위치로 URL 맵핑을 강제할 수 있다.
        return "redirect:/";
    }
}
