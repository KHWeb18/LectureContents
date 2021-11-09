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
@CrossOrigin(origins= "http://localhost:8080", allowedHeaders = "*")
public class VueCommController {

    @Autowired
    private RandNumService randNumService;

    //서버란 클라이언트에게 서비스 제공
    //클라이언트는 자신이 요청한 서비스를 받음
    //사용자가 요청할 URL을 맵핑함(서비스 요청)
    //ResponseBody가 붙어있으면 리턴하는 값을 json형식으로 만들어줌
    @GetMapping("/ramdom")
    @ResponseBody
    public ResponseEntity<RandNumMessage> getRandom(){
        log.info("gerRandom() request from vue");

        //서버에서 제공해주는 데이터
        RandNumMessage random = randNumService.getRandom();

        return ResponseEntity.ok(random);

    }

}
