package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Member;
import com.example.FirstProject.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberService service;

    @GetMapping("/join")
    public String getJoin (Member member, Model model) throws Exception{
        log.info("getJoin()");

        return "/member/join";
    }
    @PostMapping("/join")
    public String postJoin (Member member, Model model) throws Exception{
        log.info("postJoin()");

        String pw = member.getPw();
        if(pw.length() < 8 ){
            return "redirect:/join";
        }

        service.signup(member);

        model.addAttribute("msg", "회원가입이 완료되었습니다!");

        return "member/success_join";
    }
    @GetMapping("/login")
    public String getLogin (Member member, Model model) throws Exception{
        log.info("getLogin()");

        return "member/login";
    }
    @PostMapping("/login")
    public String postLogin (Member member, Model model) throws Exception{
        log.info("postLogin()");

        service.login(member);

        model.addAttribute("msg", "로그인이 완료되었습니다.");

        return "member/success_login";
    }
    @GetMapping("/my_page")
    public String getMyPage (String pw, Model model) throws Exception {
        log.info("getMyPage()");

        model.addAttribute(service.myPage(pw));

        return "member/my_page";

    }

}
