package com.example.miniProject.controller.membership;

import com.example.miniProject.entity.Membership;
import com.example.miniProject.service.VueMembershipService;
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
@RequestMapping("/vuemembership")
@CrossOrigin(origins = "http://localHost:8080", allowedHeaders = "*")
public class VueMembershipController {

    @Autowired
    private VueMembershipService service;

    // Validated: 값이 올바르게 들어오는지 검증함
    // ResponseBody 가 붙어 있으면 리턴하는 값을 json 형식으로 만들어줌
    @PostMapping("/register")
    public ResponseEntity<Membership> register(@Validated @RequestBody Membership membership) throws Exception {
        log.info("post register request from vue");

        service.register(membership);

        return new ResponseEntity<>(membership, HttpStatus.OK);
    }
}
