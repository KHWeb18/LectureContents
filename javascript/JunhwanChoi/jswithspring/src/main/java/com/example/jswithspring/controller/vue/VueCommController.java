package com.example.jswithspring.controller.vue;

import com.example.jswithspring.entity.RandNumMessage;
import com.example.jswithspring.service.RandNumService;
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

    //서버란? 클라이언트에게 서비스 제공
    //클라이언트? 서버와 통신하며 사용자에게 서비스 제공
    //ResponseBody가 붙어 있으면 리턴하는 값을 json형식으로 만들어줌
    @GetMapping("/random") //사용자가 요청한 url을 맵핑함(서비스요청)

    @ResponseBody
    public ResponseEntity<RandNumMessage> getRandom() {
        log.info("getRandom() request from vue");

        //서버에서 제공해주는 랜덤 데이터
        RandNumMessage random = randNumService.getRandom();

        return ResponseEntity.ok(random);
    }
}