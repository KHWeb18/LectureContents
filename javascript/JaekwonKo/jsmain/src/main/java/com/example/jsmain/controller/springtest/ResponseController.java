package com.example.jsmain.controller.springtest;


import com.example.jsmain.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ResponseController {

    @GetMapping("/jsonMember")
    public Member jsonMember () {
        log.info("jsonMember()");

        Member member = new Member();
        member.setId("name");
        member.setPw("test");

        return member;
    }
}
