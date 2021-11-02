package com.example.demo.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ThirdController {
    @GetMapping("/checkbox")
    public String checkboxTest () {
        log.info("checkbox()");

        return "/third/checkbox";
    }

    @GetMapping("/radioTest")
    public String radioTest () {
        log.info("radioTest()");

        return "/third/radio";
    }

    @GetMapping("/formRadio")
    public String formRadio () {
        log.info("formRadio()");

        return "/third/formRadio";
    }
    @GetMapping("/test")
    public String test () {
        log.info("test()");

        return "redirect:/";
    }
    @GetMapping("/font")
    public String font () {
        log.info("font()");

        return "redirect:/";
    }
    @GetMapping("/fieldsetLogin")
    public String fieldsetLogin () {
        log.info("fieldsetLogin()");

        return "/third/fieldsetLogin";
    }

    @GetMapping("/numberRange")
    public String numberRange () {
        log.info("numberRange()");

        return "/third/numberRange";
    }
    @GetMapping("/buttonTest")
    public String buttonTest () {
        log.info("buttonTest()");

        return "/third/button";
    }
    @GetMapping("/selectTest")
    public String selectTest () {
        log.info("selectTest()");

        return "/third/select";
    }
    @GetMapping("/optgroup")
    public String optgroup () {
        log.info("optgroup()");

        return "/third/optgroup";
    }

}
