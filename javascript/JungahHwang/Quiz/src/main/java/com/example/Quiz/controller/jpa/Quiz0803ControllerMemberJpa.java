package com.example.Quiz.controller.jpa;

import com.example.Quiz.entity.jpa.Member;
import com.example.Quiz.service.jpa.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Quiz0803ControllerMemberJpa {

    @Autowired
    MemberService service;

    @PostMapping("/memberjpa")
    public ResponseEntity<Member> postMemberJpa(@Validated @RequestBody Member member) throws Exception {
        log.info("postMemberJpa");

        service.signup(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}


































