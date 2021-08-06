package com.example.demo.controller.jpa;

import com.example.demo.controller.jpa.request.MemberRequest;
import com.example.demo.entity.jpa.Member;
import com.example.demo.service.jpa.MemberService;
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
public class Controller0805Member {

    @Autowired
    private MemberService service;

    @PostMapping("/register")
    public ResponseEntity<Void> jpaRegister(@Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("jpaRegister(id: " + memberRequest.getId() + ", pw: " + memberRequest.getPw() + ", " +
                (memberRequest.getAuth().equals("사업자") ? "ROLE_BUSINESS)" : "ROLE_INDIVIDUAL)"));

        service.register(memberRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

















