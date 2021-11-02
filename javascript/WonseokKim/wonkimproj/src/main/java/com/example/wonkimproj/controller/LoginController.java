package com.example.wonkimproj.controller;

import com.example.wonkimproj.entity.Login;
import com.example.wonkimproj.entity.Register;
import com.example.wonkimproj.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private LoginService service;

    @GetMapping("/login")
    public String getLogin (Login login, Model model) {
        log.info("getLogin()");

        return "/login/login";
    }

    @PostMapping("/login")
    public String postLogin (Login login, Model model) throws Exception {
        log.info("postLogin()");
        log.info("Login: " + login);

        service.login(login);

        model.addAttribute("msg", "로그인을 환영합니다!");

        return "/login/success";
    }
}
