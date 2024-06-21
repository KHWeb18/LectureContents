package com.example.jsmain.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ThirdController {

    @GetMapping("/checkbox")
    public String checkbox() {
        log.info("checkbox()");

        return "third/checkbox";
    }

    @GetMapping("/radioTest")
    public String radioTest() {
        log.info("radioTest()");

        return "/third/radioTest";
    }

    @GetMapping("/formRadio")
    public String formRadio() {
        log.info("formRadio()");

        return "/third/formRadio";
    }

    @GetMapping("/test")
    public String test() {
        log.info("test()");

        return "redirect:/";
    }

    @GetMapping("/fieldsetLogin")
    public String fieldsetLogin() {
        log.info("fieldsetLogin()");

        return "/third/fieldsetLogin";
    }

    @GetMapping("/numberRange")
    public String numberRange() {
        log.info("numberRange()");

        return "/third/numberRange";
    }

    @GetMapping("/button")
    public String button() {
        log.info("button()");

        return "/third/button";
    }

    @GetMapping("/select")
    public String select() {
        log.info("select()");

        return "/third/select";
    }

    @GetMapping("/optgroup")
    public String optgroup() {
        log.info("optgroup()");

        return "/third/optgroup";
    }
}
