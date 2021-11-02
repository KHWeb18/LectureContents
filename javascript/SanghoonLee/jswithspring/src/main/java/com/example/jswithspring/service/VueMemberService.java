package com.example.jswithspring.service;

import com.example.jswithspring.entity.Member;

import java.util.List;

public interface VueMemberService {
    public void register(Member member) throws Exception;
    public void login(Member member) throws Exception;
    public List<Member> list() throws Exception;
}
