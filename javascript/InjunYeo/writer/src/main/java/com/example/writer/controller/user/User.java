package com.example.writer.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(value="/user")

public class User {
    /*
    @Autowired
    private UserService service;
     */

    @PostMapping("/login")
    public String postUserLogin(){
        log.info("postUserLogin()");

        return"user/success";
    }
    @GetMapping("/login")
    public String getLogin(){
        log.info("getLogin()");

        return "user/login";
    }



    @GetMapping("/register")
    public String getUserRegister(){
        log.info("getUserRegister()");

        return"user/register";
    }

    @PostMapping("/register")
    public String postRegister (User user, Model model) throws Exception{
        log.info("postRegister()");
        log.info("User: " +user);

        //service.register(user);

        model.addAttribute("msg","writer에 오신것을 환영합니다");

        return "/user/success";
    }



}
