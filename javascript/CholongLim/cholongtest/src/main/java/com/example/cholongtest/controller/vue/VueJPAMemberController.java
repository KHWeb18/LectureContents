package com.example.cholongtest.controller.vue;

import com.example.cholongtest.entity.VueMember;
import com.example.cholongtest.service.VueJPAMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/vuejpamember")
@CrossOrigin(origins = "http://localHost:8080", allowedHeaders = "*")
public class VueJPAMemberController {

    @Autowired
    private VueJPAMemberService service;

    @PostMapping("/register")
    public ResponseEntity<VueMember> register(@Validated @RequestBody VueMember vueMember) throws Exception {
        log.info("post register request from vue");

        service.register(vueMember);

        return new ResponseEntity<>(vueMember, HttpStatus.OK);
    }
}
