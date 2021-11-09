package com.example.demo.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ThirdController {

    @GetMapping("/checkboxTest")
    public String checkboxTest(){
        log.info("checkboxTest()");

        return "third/checkBox";
    }


    @GetMapping("/radioTest")
    public String radioTest(){
        log.info("radioTest()");

        return "third/radio";
    }

    @GetMapping("/formRadio")
    public String formRadioTest(){
            log.info("formRadioTest()");

            return "third/formRadio";
    }

    @GetMapping("/test")
    public String test(){
        log.info("test()");

        //redirect를 사용하면 스택쌓이는걸 방지할수있다.
        return "redirect:/";
    }

    @GetMapping("/filedsetLoginTest")
    public String filedsetLoginTest(){
        log.info("filedsetLoginTest()");


        return "third/fieldsetLogin";
    }

    @GetMapping("/numberRange")
    public String numberRange(){
        log.info("numberRange()");

        return "third/numberRange";
    }

    @GetMapping ("/buttonTest")
    public String buttonTest(){
        log.info("buttonTest()");

        return "third/buttonTest";
    }

    @GetMapping("/selectTest")
    public String selecTest(){
        log.info("selectTest");

        return "third/select";
    }

    @GetMapping("/optgroup")
    public String optgroup(){
        log.info("optgroup()");

        return "third/optgroup";
    }


}
