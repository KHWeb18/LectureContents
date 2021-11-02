package com.example.projectTest.controller;

import com.example.projectTest.entity.Member;

import com.example.projectTest.service.VueMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueMemberController {

    @Autowired
    private VueMemberService service;

    @PostMapping("/register")
    public ResponseEntity<Member> register(@Validated @RequestBody Member member) throws Exception {
        log.info("post register request from vue");

        service.register(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Member>> getLists () throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{memberNo}")
    public ResponseEntity<Member> read(@PathVariable("memberNo") Integer memberNo) throws Exception {
        Member member = service.read(memberNo);

        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }


    @PutMapping("/{memberNo}")
    public ResponseEntity<Member> modify(@PathVariable("memberNo") Integer memberNo,
                                        @Validated @RequestBody Member member) throws Exception {
        member.setMemberNo(memberNo);
        service.modify(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }
    @DeleteMapping("/{memberNo}")
    public ResponseEntity<Void> remove(@PathVariable("memberNo") Integer memberNo) throws  Exception{
        service.remove(memberNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}