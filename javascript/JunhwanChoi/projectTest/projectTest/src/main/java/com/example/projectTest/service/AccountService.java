package com.example.projectTest.service;

import com.example.projectTest.controller.request.MemberRequest;
import com.example.projectTest.controller.request.SignInForm;
import com.example.projectTest.entity.Member;

import java.util.Optional;

public interface AccountService {
    public void register(SignInForm form) throws Exception;
}