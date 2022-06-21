package com.example.demo.controller.vue;

import com.example.demo.entity.VueJPAMember;
import com.example.demo.service.VueJPAMemberService;
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
@RequestMapping("/vuejpamember")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class VueJPAMemberController {

    @Autowired
    private VueJPAMemberService service;

    @PostMapping("/register")
    public ResponseEntity<VueJPAMember> register(@Validated @RequestBody VueJPAMember member) throws Exception {
        log.info("post register request from vue");

        service.register(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
