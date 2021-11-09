package com.example.demo.controller.board;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class FourthController {

    @Autowired
    private BoardService service;

    @GetMapping("/register")
    public String getRegister (Board board, Model model) {
        log.info("getRegister()");

        return "/board/fourth/register";
    }

    @PostMapping("/register")
    public String postRegister (Board board, Model model) throws Exception{
        log.info("postRegister()");

        log.info("Board: " + board);

        service.register(board);

        model.addAttribute("msg", "등록 완료!");

        return "/board/fourth/success";
    }

    @GetMapping("/joinMembership")
    public String getJoinMembership (Member signup, Model model) {
        log.info("getJoinMembership()");

        return "/signup/joinMemberShip";
    }

    @PostMapping("/joinMembership")
    public String postSignUp (Member signup, Model model) throws Exception{
        log.info("postJoinMembership()");
        log.info("Signup: " + signup);

        model.addAttribute("signup", "가입완료");

        return "/signup/signupSuccess";
    }
    //dddd

}
