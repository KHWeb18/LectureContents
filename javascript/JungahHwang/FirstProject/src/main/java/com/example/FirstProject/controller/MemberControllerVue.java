package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Member;
import com.example.FirstProject.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.PushbackInputStream;

@Slf4j
@Controller
@RequestMapping("/vue")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberControllerVue {

    @Autowired
    private MemberService service;

    @PostMapping("/signup")
    public ResponseEntity<Member> join(@Validated @RequestBody Member member) throws Exception {
        log.info("success");

        service.signup(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
