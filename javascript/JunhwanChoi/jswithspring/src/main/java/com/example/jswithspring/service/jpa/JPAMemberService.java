package com.example.jswithspring.service.jpa;

import com.example.jswithspring.controller.vue.jpa.request.MemberRequest;

public interface JPAMemberService {
    public void register(MemberRequest memberRequest) throws Exception;
    /*
    public void login(Member member) throws Exception;
    public List<Member> list() throws Exception;
     */
}