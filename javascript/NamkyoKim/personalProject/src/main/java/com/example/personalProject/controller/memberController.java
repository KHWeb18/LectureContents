package com.example.personalProject.controller;

import com.example.personalProject.eutity.Member;
import com.example.personalProject.eutity.VueJPAMember;
import com.example.personalProject.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
public class memberController {

        @Autowired
        private MemberService service;


        @GetMapping("/join")
        public String getJoin(Member member, Model model) {
            log.info("getJoin()");

            return "/member/join";
        }

        @PostMapping("/join")
        public String postJoin(Member member, Model model) throws Exception {
            log.info("postJoin()");

            log.info("Member: " + member);

             /* 비밀번호 길이 체크 로직 시작 */
            String pw = member.getPw();
            if (pw.length() <= 8 || pw.length() > 20 ){
                // model.addAttribute("alertMsg", "8~ 20 이내의 비밀번호를 기재해주세요");
                return "redirect:/join";
            }
            /* 비밀번호 길이 체크 로직 끝 */
            service.join(member);

            // msg 라는 속성값에 "등록이 완료되었습니다!"을 맵핑함
            // key: msg, value: "등록이 완료되었습니다!" 라고 생각하면 편함
            model.addAttribute("msg", "가입이 완료되었습니다!");

            return "/member/joinSuccess";
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

        return "/member/loginSuccess";
    }


    @GetMapping("/memberLists")
    public String getLists(Model model) throws Exception{
        log.info("getMemberLists()");

        model.addAttribute("member", service.list());

        return "/member/memberLists";
    }

    @GetMapping("/memberModify")
    public String getMemberModify(int memberNo, Model model)throws Exception{
        log.info("getMemberModify()");

        // 수정을 눌렀을때 기존 정보를 가져와야함
        model.addAttribute(service.read(memberNo));

        return "/member/memberModify";
    }

    @PostMapping("/memberModify")
    public String memberModify(Member member, Model model)throws Exception{
        log.info("postMemberModify()");

        service.modify(member);

        model.addAttribute("msg","수정이 성공적으로 완료되었습니다!");
        return "/member/modifySuccess";
    }

}


