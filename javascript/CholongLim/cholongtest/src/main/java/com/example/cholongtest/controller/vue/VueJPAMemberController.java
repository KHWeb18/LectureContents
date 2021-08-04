package com.example.cholongtest.controller.vue;

import com.example.cholongtest.entity.Member;
import com.example.cholongtest.entity.VueJPAMember;
import com.example.cholongtest.service.VueJPAMemberService;
import com.example.cholongtest.service.VueMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vuejpamember")
@CrossOrigin(origins = "http://localHost:8080", allowedHeaders = "*")
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
