package com.example.demo.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ThirdController {

    @GetMapping("/checkboxTest")
    public String checkboxTest () {
        log.info("checkboxTest()");

        return "/third/checkbox.html";
    }

    @GetMapping("/radioTest")
    public String radioTest () {
        log.info("radioTest()");

        return "/third/radio";
    }

    @GetMapping("/formRadioTest")
    public String formRadioTest () {
        log.info("formRadioTest()");

        return "/third/formRadio";
    }

    @GetMapping("/test")
    public String test () {
        log.info("test()");

        return "redirect:/";
    }

    @GetMapping("/fieldsetLoginTest")
    public String fieldsetLoginTest () {
        log.info("fieldsetLoginTest()");

        return "/third/fieldsetLogin";
    }

    @GetMapping("/numberRangeTest")
    public String numberRangeTest () {
        log.info("numberRangeTest()");

        return "/third/numberRange";
    }

    @GetMapping("/buttonTest")
    public String buttoneTest () {
        log.info("buttonTest()");

        return "/third/button";
    }

    @GetMapping("/selectTest")
    public String selectTest () {
        log.info("selectTest()");

        return "/third/select";
    }

    @GetMapping("/optgroupTest")
    public String optgroupTest () {
        log.info("optgroupTest()");

        return "/third/optgroup";
    }
}
