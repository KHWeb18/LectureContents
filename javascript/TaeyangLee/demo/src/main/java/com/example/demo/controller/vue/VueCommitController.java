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
public class VueCommitController {
    @Autowired
    private RandNumService randNumService;

    //서버의 정의는? 클라이언트에 서비스제공
    //클라이언트는 어떤 서비스를 받는가? 클라이언트가 요청한 서비르를받음
    @GetMapping("/random")
    @ResponseBody
    public ResponseEntity<RandNumMessage> getRandom() {
        log.info("getRandom() request from vue");

        RandNumMessage random = randNumService.getRandom();

        return ResponseEntity.ok(random);
    }
}
