package com.example.Quiz.service;

import com.example.Quiz.entity.Member;

import java.util.List;

public interface VueMemberService {
    public void signup(Member member) throws Exception;
    public void login(Member member) throws Exception;
    public List<Member> memberList() throws Exception;
}
