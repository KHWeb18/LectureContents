package com.example.demo.controller.vue.jpa;

import com.example.demo.controller.vue.jpa.request.MemberRequest;
import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.MemberAuth;
import com.example.demo.service.jpa.JPAMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/jpamember")
@CrossOrigin(origins = { "http://localhost:7777", "http://localhost:8080" }, allowedHeaders = "*")
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
        // get은 정보가져오기. 가져올 데이터가 없으면 그냥 둠
        Member member = maybeMember.get();

        // 사업자로 넘어오면 ROLE_BUSINESS로 아니면 ROLE_CUSTOMER로 보이게
        log.info("Auth: " + (member.getAuthList().get(0).getAuth().equals("사업자") ?
                "ROLE_BUSINESS" : "ROLE_CUSTOMER"));

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}