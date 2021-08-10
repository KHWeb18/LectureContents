package com.example.demo.service.jpa;

import com.example.demo.controller.vue.jpa.request.MemberRequest;
import com.example.demo.entity.jpa.Member;

import java.util.List;
import java.util.Optional;


public interface JPAMemberService {
    void register(MemberRequest memberRequest) throws Exception;

    boolean login(MemberRequest memberRequest) throws Exception;
    /*
    public List<Member> list() throws Exception;
     */
    Optional<Member> findByAuth(Long memberNo);
}
