package com.example.jswithspring.controller.vue.jpa;

import com.example.jswithspring.entity.jpa.Member;
import com.example.jswithspring.service.jpa.MemberService;
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
@RequestMapping("/jpamember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping("/register")
    public ResponseEntity<Member> jpaRegister(@Validated @RequestBody Member member) throws Exception {
        log.info("jpaRegister():" + member + ", kinds:" + kinds);;

        service.register(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}