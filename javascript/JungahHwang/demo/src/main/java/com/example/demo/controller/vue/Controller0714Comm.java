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

// vue와 통신하기 위한 controller
@Slf4j
@Controller
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Controller0714Comm {
    @Autowired
    private RandNumService randNumService;

    // server: 클라이언트에게 서비스 제공
    // 클라이언트는 클라이언트(사용자)가 요청한 서비스를 받음
    // 사용자가 서비스를 요청할 URL을 맵핑
    // ResponseBody: 리턴하는 값을 json형식으로 만들어 줌
    @GetMapping("/random")
    @ResponseBody
    public ResponseEntity<RandNumMessage> getRandom() {
        log.info("getRandom() request from vue");

        // 서버에서 제공해주는 랜덤 데이터(random이 json형태로 변환되어 넘어감)
        RandNumMessage random = randNumService.getRandom();

        return  ResponseEntity.ok(random);
    }
    // -> 결국 사용자가 요청한 랜덤 숫자(데이터)를 제공하는 것이 이 컨트롤러의 역할
}
























