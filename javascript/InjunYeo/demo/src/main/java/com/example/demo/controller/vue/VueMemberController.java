package com.example.demo.controller.vue;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.service.VueBoardService;
import com.example.demo.service.VueMemberService;
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
@RequestMapping("/vuemember")
@CrossOrigin(origins= "http://localhost:8080", allowedHeaders = "*")
public class VueMemberController {

    @Autowired
    private VueMemberService service;


    @PostMapping("/register")
    public ResponseEntity<Member> register(@Validated @RequestBody Member member) throws Exception{
        log.info("post register request from vue()");

        service.register(member);


        return new ResponseEntity<Member>(member, HttpStatus.OK);

    }





}
