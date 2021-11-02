package com.example.jsmain.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller

public class FourthVueController {

    @GetMapping("/fourthVue")
    public String getFourthVue(){
        log.info("getFourthVue()");

        return "/vue/fourth";
    }


}
