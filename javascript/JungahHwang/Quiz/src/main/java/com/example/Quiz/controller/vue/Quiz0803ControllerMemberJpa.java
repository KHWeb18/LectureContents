package com.example.Quiz.controller.vue;

import com.example.Quiz.entity.MemberJpa;
import com.example.Quiz.service.MemberJpaService;
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
    MemberJpaService service;

    @PostMapping("/memberjpa")
    public ResponseEntity<MemberJpa> postMemberJpa(@Validated @RequestBody MemberJpa member) throws Exception {
        log.info("postMemberJpa");

        service.signup(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}


































