package com.example.cholongtest.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstController {
    @GetMapping("/htmlList")
    public String doHtmlList() {
        log.info("doHtmlList()");

        return "first/list";
    }

    @GetMapping("/imageTest")
    public String doimageLTest() {
        log.info("doimageTest()");

        return "first/image";
    }

    @GetMapping("/fontTest")
    public String dofontTest() {
        log.info("dofontTest()");

        return "first/font";
    }

    @GetMapping("/markTest")
    public String domarkTest() {
        log.info("domarkTest()");

        return "first/mark";
    }

    @GetMapping("/firsttableTest")
    public String firsttableTest() {
        log.info("firsttableTest()");

        return "first/tableTest1";
    }

    @GetMapping("/secondtableTest")
    public String secondtableTest() {
        log.info("secondtableTest()");

        return "first/tableTest2";
    }

    @GetMapping("/thirdtableTest")
    public String thirdtableTest() {
        log.info("thirdtableTest()");

        return "first/tableTest3";
    }

    @GetMapping("/CholongLimResume")
    public String CholongLimResume() {
        log.info("CholongLimResume()");

        return "first/resume";
    }
}
