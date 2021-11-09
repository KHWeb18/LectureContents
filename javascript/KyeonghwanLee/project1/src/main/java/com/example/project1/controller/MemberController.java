package com.example.project1.controller;

import com.example.project1.entity.Member;
import com.example.project1.service.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private SignUpService service;

    @GetMapping("/signup")
    public String getSignUp (Member member, Model model) throws Exception {
        log.info("getSignUp()");

        return "/member/signup";
    }

    @PostMapping("/signup")
    public String postSignUp (Member member, Model model) throws Exception {
        log.info("postSignup()");
        log.info("Member: " + member);


        /* 비밀번호 길이 체크 로직 시작 */
        String pw = member.getPw();
        if (pw.length() <= 8) {
            // model.addAttribute("alertMsg", "8자리 이상의 비밀번호를 기입해주세요");
            return "redirect:/member/signup";
        }

            service.signup(member);
            model.addAttribute("msg", "가입이 완료되었습니다!");

            return "/member/success";

    }

    @GetMapping("/login")
    public String getLogin (Member member, Model model) {
        log.info("getLogin()");

        return "/member/login";
    }

    @PostMapping("/login")
    public String postLogin (Member member, Model model) throws Exception {
        log.info("postLogin(): " + member);

        service.login(member);

        model.addAttribute("msg", "로그인 성공!");

        return "/member/success";
    }
    @GetMapping("/memberLists")
    public String getLists (Model model) throws Exception {
        log.info("getLists(): " + service.memberList());

        model.addAttribute("member", service.memberList());

        return "/member/memberLists";
    }

}


