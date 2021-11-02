package com.example.demo.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SixthVueController {

    @GetMapping("/sixthVue")
    public String getSixthVue () {
        log.info("getSixthVue()");

        return "/vue/sixth";
    }
}