package com.example.demo.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ThirdController {

    @GetMapping("/checkboxTest")
    public String checkboxTest(){

        log.info("checkboxTest()");

        return "/third/checkbox";
    }

    @GetMapping("/radioTest")
    public String radioTest(){
        log.info("radioTest()");

        return "/third/radio";
    }
    @GetMapping("/formRedioTest")
    public String formRedioTest(){
        log.info("formRadioTest()");

        return "/third/formRadio";
    }
    @GetMapping("/test1")
    public String test1(){
        log.info("test1()");

        return "redirect:/";
    }

    @GetMapping("/fileldsetLoginTest")
    public String fileldsetLoginTest(){
        log.info("fileldsetLoginTest()");

        return "/third/fileldsetLogin";
    }
    @GetMapping("/numberRangeTest")
    public String numberRangeTest(){
        log.info("numberRangeTest()");

        return "/third/numberRange";
    }
    @GetMapping("/buttonTest")
    public String buttonTest(){
        log.info("buttonTest()");

        return "/third/button";
    }
    @GetMapping("/selectTest")
    public String selectTest(){
        log.info("selectTest()");

        return "/third/select";
    }
    @GetMapping("/optgroupTest")
    public String optgroupTest(){
        log.info("optgroupTest()");

        return "/third/optgroup";
    }
}
