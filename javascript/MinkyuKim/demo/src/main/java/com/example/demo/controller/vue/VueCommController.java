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

// Vue와 통신을 하기 위한 컨트롤러
@Slf4j
@Controller
// allowedHeaders = "*"는 어떠한 연결이든 허용한다는 의미.
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueCommController {

    @Autowired
    private RandNumService randNumService;

    // 서버의 정의는? 클라이언트에게 서비스 제공 <<<
    // 클라이언트는 어떤 서비스를 받는가 ? 클라이언트(사용자)가 요청한 서비스를 받음
    // GetMapping 사용자가 요청할 URL을 맵핑함(서비스 요청)
    // ResponseBody가 붙어 있으면 리턴하는 값을 json 형식으로 만들어줌(ResponseBody로 인하여 아래의 return ~~(random)값이 json형태로 넘어오게됨.)
    // 한마디로 이 controller의 역할은 아래는 사용자가 요청을하면 random 데이터를 생성하여 json형태로 넘겨준다.
    @GetMapping("/random")
    @ResponseBody
    public ResponseEntity<RandNumMessage> getRandom() {
        log.info("getRandom() request from vue");

        // 서비스에서 제공해주는 랜덤 데이터
        RandNumMessage random = randNumService.getRandom();

        return ResponseEntity.ok(random);
    }
}
