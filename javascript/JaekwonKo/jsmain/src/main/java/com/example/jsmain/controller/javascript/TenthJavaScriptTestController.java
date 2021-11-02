package com.example.jsmain.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TenthJavaScriptTestController {

    @GetMapping("getJavaScriptPromptTest")
    public String getJavaScriptPromptTest() {
        log.info("getJavaScriptPromptTest()");

        return "/javascript/tenth/prompt";
    }

    @GetMapping("/getQuerySelectTest")
    public String getQuerySelectTest() {
        log.info("getQuerySelectTest()");

        return "/javascript/tenth/querySelect";
    }

    @GetMapping("/getDivideElementTest")
    public String getDivideElementTest() {
        log.info("getDivideElementTest()");

        return "/javascript/tenth/divideElement";
    }

    @GetMapping("/getJavaScriptTimeTest")
    public String getJavaScriptTimeTest() {
        log.info("getJavaScriptTimeTest()");

        return "/javascript/tenth/jsTime";
    }

    @GetMapping("/getSaleProductTest")
    public String getSaleProductTest() {
        log.info("getSaleProductTest()");

        return "/javascript/tenth/saleProduct";
    }

    @GetMapping("/getIfTest")
    public String getIfTest() {
        log.info("getIfTest()");

        return "/javascript/tenth/ifTest";

    }

    @GetMapping("/getSwitchTest")
    public String getSwitchTest() {
        log.info("getSwitchTest()");

        return "/javascript/tenth/switchTest";

    }

    @GetMapping("/getForTest")
    public String getForTest() {
        log.info("getForTest");

        return "/javascript/tenth/forTest";
    }

    @GetMapping("/getAddNumber")
    public String getAddNumber() {
        log.info("getAddNumber()");

        return "/javascript/tenth/addNum";
    }

    @GetMapping("/getMouseOverTest")
    public String getMouseOverTest() {
        log.info("getMouseOverTest()");

        return "/javascript/tenth/mouseOver";
    }

    @GetMapping("/getInvisibilityTest")
    public String getInvisibilityTest() {
        log.info("getInvisibilityTest()");

        return "/javascript/tenth/invisibility";
    }
}
