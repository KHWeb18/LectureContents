package com.example.jsmain.service.jpa;

import com.example.jsmain.controller.vue.jpa.request.MemberRequest;
import com.example.jsmain.entity.jpa.Member;

import java.util.List;

public interface JPAMemberService {
    public void register(MemberRequest memberRequest) throws Exception;
    /*
    public void login(Member member) throws Exception;
    public List<Member> list() throws Exception;

     */
}