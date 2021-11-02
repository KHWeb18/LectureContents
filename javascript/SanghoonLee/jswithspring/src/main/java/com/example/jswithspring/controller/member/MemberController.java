package com.example.jswithspring.controller.member;

import com.example.jswithspring.entity.Board;
import com.example.jswithspring.entity.Member;
import com.example.jswithspring.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/register")
    public String getMemberRegister (Member member, Model model) {
        log.info("getMemberRegister()");

        return "/member/register";
    }

    @PostMapping("/register")
    public String postMemberRegister (Member member, Model model) throws Exception {
        log.info("postMemberRegister()");
        log.info("Member: " + member);

        /* 비밀번호 길이 체크 로직 시작 */
        String pw = member.getPw();
        if (pw.length() <= 8) {
            // model.addAttribute("alertMsg", "8자리 이상의 비밀번호를 기입해주세요");
            return "redirect:/member/register";
        }
        /* 비밀번호 길이 체크 로직 끝 */

        service.register(member);

        model.addAttribute("msg", "등록이 완료되었습니다!");

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

    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getLists(): " + service.list());

        model.addAttribute("member", service.list());

        return "/member/memberIdList";
    }

    @DeleteMapping("/test-del")
    public void testDelete() {
        log.info("test-del");
    }
}
