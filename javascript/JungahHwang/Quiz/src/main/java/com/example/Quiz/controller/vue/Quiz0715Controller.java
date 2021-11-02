package com.example.Quiz.controller.vue;

import com.example.Quiz.entity.Member;
import com.example.Quiz.service.VueMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/vuegame")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Quiz0715Controller {

    @Autowired
    private VueMemberService service;

    @PostMapping("/signup")
    public ResponseEntity<Member> register(@Validated @RequestBody Member member) throws Exception {
        log.info("post register request fro vue");

        service.signup(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

}
