package com.example.demo.controller.vue;

import com.example.demo.entity.RandNumMessage;
import com.example.demo.service.RandNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueCommController {

    @Autowired
    private RandNumService randNumService;

    @GetMapping("/random")
    @ResponseBody
    public ResponseEntity<RandNumMessage> getRandom() {
        log.info("getRandom() request from vue");

        RandNumMessage random = randNumService.getRandom();

        return ResponseEntity.ok(random);
    }
}