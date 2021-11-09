package com.example.FirstProject.service;

import com.example.FirstProject.entity.Member;

public interface MemberService {
    public void signup(Member member) throws Exception;
    public void login(Member member) throws Exception;
    public Member myPage(String pw) throws Exception;
}
