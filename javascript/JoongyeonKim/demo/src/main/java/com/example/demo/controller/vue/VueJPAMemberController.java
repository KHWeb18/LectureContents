package com.example.demo.controller.vue;

import com.example.demo.entity.Member;
import com.example.demo.entity.Monster;
import com.example.demo.entity.VueMember;
import com.example.demo.service.VueJPAMemberService;
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
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueJPAMemberController {

    @Autowired
    private VueJPAMemberService service;

    @PostMapping("/register")
    public ResponseEntity<VueMember> register(@Validated @RequestBody VueMember member) throws Exception {
        log.info("post register request from vue");

        service.register(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }
/*
    @GetMapping("/lists")
    public ResponseEntity<List<VueMember>> getLists () throws Exception {
        log.info("getLists(): " + service.lists());

        return new ResponseEntity<>(service.lists(), HttpStatus.OK);
    }

 */
}
