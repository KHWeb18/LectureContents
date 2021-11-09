package com.example.jswithspring.controller.webgl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/webgl")
public class WebGLController {

    @GetMapping("/game")
    public String getGame() {
        log.info("getGame()");

        return "webgl/webgl_start";
    }

    @GetMapping("/backshot")
    public String getBackshot() {
        log.info("getGame()");

        return "webgl/back_shot";
    }
}
