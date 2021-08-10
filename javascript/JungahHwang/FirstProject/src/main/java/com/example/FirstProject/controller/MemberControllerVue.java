package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Member;
import com.example.FirstProject.service.MemberService;
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
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberControllerVue {

    @Autowired
    private MemberService service;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Validated @RequestBody Member member) throws Exception {
        log.info("Signup");

        service.signup(member);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Member member) throws Exception {
        log.info("Login");

        Boolean isSuccess = service.login(member);

        if (isSuccess) {
            log.info("Login Success");
        } else {
            log.info("Login Failure");
        }

        return new ResponseEntity<Boolean>(isSuccess, HttpStatus.OK);
    }
}
