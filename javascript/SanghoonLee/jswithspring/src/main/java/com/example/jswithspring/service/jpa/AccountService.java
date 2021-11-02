package com.example.jswithspring.service.jpa;

import com.example.jswithspring.controller.vue.jpa.request.MemberRequest;
import com.example.jswithspring.controller.vue.jpa.request.SignInForm;
import com.example.jswithspring.entity.jpa.Member;

import java.util.Optional;

public interface AccountService {
    public void register(SignInForm form) throws Exception;
}
