package com.example.jsmain.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ResumeController {
    @GetMapping("/resume")
    public String doResume(){
        log.info("doResume()");
        return "homeWork/resume";
    }
}
