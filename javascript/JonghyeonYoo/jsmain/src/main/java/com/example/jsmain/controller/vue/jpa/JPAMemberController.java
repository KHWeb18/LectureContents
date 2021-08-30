package com.example.jsmain.controller.vue.jpa;

import com.example.jsmain.controller.vue.jpa.request.MemberRequest;
import com.example.jsmain.entity.jpa.Member;
import com.example.jsmain.service.jpa.JPAMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/jpamember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPAMemberController {

    @Autowired
    private JPAMemberService service;

    @PostMapping("/register")
    public ResponseEntity<Void> jpaRegister(
            @Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getPassword() + ", " +
                (memberRequest.getAuth().equals("사업자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        service.register(memberRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<Void> jpaJPQLTest(
            @RequestBody MemberRequest memberRequest) throws Exception {

        log.info("jpaJPQLTest()");

        Optional<Member> maybeMember = service.findByAuth(new Long(3));
        Member member = maybeMember.get();

        log.info("Auth: " + (member.getAuthList().get(0).getAuth().equals("사업자") ?
                "ROLE_BUSINESS" : "ROLE_CUSTOMER"));

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}