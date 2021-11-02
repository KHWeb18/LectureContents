package com.example.demo.controller.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstController {

    @GetMapping("/CAT")
    public String firstIndex() {
        log.info("CAT출력 실행");

        return "first/Cathtml";
    }


}
