package com.example.jswithspring.controller.springtest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class HttpMethodMainController {

    @GetMapping("/main")
    public String getMain(){
        log.info("getMain()");

        return "/httpmethod/main";
    }
}
