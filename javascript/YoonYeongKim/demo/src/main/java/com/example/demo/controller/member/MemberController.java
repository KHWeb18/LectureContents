package com.example.demo.controller.member;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
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
    private MemberService service;

    @GetMapping("/signup")
    public String getSignUp (Member member, Model model) {
        log.info("getSignUp()");

        return "/member/signup";
    }

    @PostMapping("/signup")
    public String postSignUp (Member member, Model model) throws Exception {
        log.info("postSignUp()");
        log.info("Member: " + member);

        // 비밀번호 길이 체크 로직 시작점
        // 비밀번호 길이 8개 이하면 X
        String pw = member.getPw();
        if (pw.length() <= 8) {

            // model.addAttribute("alertMsg", "8자리 이상의 비밀번호를 기입해주세요");

            return "redirect:/member/signup";
        }
        // 비밀번호 길이 체크 로직 끝

        service.signup(member);

        model.addAttribute("msg", "가입이 완료되었습니다!");

        return "/member/success";
    }

    //-----------------------------------------------------------------------------

        @GetMapping("/login")
        public String getLogIn (Member member, Model model) {
            log.info("getLogIn()");

            return "/member/login";
        }

        @PostMapping("/login")
        public String postLogIn (Member member, Model model) throws Exception {
            log.info("postLogIn(): " + member);

            service.login(member);
            model.addAttribute("msg", "로그인이 완료되었습니다!");

            return "/member/success";
        }

        //------------------------------------------------------------------------------
        // 가입한 사용자들의 모든  id를 for문을 사용해 출력

        @GetMapping("/idLists")
        public String getLists (Model model) throws Exception {
            log.info("getLists(): " + service.list());

            model.addAttribute("member", service.list());

            return "/member/memberIdList";
    }
}