package com.example.demo.newcontroller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ThridVueController {


    @GetMapping("/vueGame")
    public String getVueGame () {
        log.info("getVueGame()");

        return "/vue/third";
    }

}
