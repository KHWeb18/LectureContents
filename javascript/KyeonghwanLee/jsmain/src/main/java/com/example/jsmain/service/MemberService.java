package com.example.jsmain.service;

import com.example.jsmain.entity.Member;

import java.util.List;

public interface MemberService {
    public void register(Member member) throws Exception;
    public void login(Member member) throws Exception;
    public List<Member> list() throws Exception;
}