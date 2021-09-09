package com.example.FirstProject.controller;

import com.example.FirstProject.controller.session.UserInfo;
import com.example.FirstProject.entity.Member;
import com.example.FirstProject.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    private UserInfo info;

    private HttpSession session;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Validated @RequestBody Member member) throws Exception {
        log.info("Member Signup");

        service.signup(member);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Member member, HttpServletRequest request) throws Exception {
        log.info("Member Login");

        Boolean isSuccess = service.login(member);

        if (isSuccess) {
            info = new UserInfo();
            info.setId(member.getId());

            session = request.getSession();
            session.setAttribute("member", info);

            log.info("Login Success");
        } else {
            info = null;

            log.info("Login Failure");
        }

        Object obj = session.getAttribute("member");

        Boolean isLogin = false;

        if (obj != null) {
            isLogin = service.validationId(info.getId());
        } else {
            isLogin = false;
        }
        log.info(String.valueOf(isLogin));

        return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        log.info("Member Logout");

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }

    @GetMapping("/mypage/{id}")
    public ResponseEntity<Optional<Member>> userInfo(@PathVariable("id") @RequestBody String id) throws Exception {

        Optional<Member> result = service.userInfo(id);

        return new ResponseEntity<Optional<Member>>(result, HttpStatus.OK);
    }
}













