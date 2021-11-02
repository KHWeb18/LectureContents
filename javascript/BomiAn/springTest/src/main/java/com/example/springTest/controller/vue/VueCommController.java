package com.example.springTest.controller.vue;

import com.example.springTest.entity.RandNumMessage;
import com.example.springTest.service.RandNumService;
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
    // 서버에 정의는? 클라이언트에게 서비스 제공
    // 클라이언트는 어떤 서비스를 받는가? 클라이언트(사용자)가 요청한 서비스를 받음
    // 사용자가 요청할 URL을 맵핑함 (서비스 요청
    // ResponseBody가 붙어 있으면 리턴하는 값을 json 형식으로 만들어줌

    @Autowired
    private RandNumService randNumService;

    @GetMapping("/random")
    @ResponseBody
    public ResponseEntity<RandNumMessage> getRandom() {
        log.info("getRandom() request from vue");

        //서버에서 제공해주는 랜덤 데이터
        RandNumMessage random = randNumService.getRandom();

        return ResponseEntity.ok(random);
    }
}
