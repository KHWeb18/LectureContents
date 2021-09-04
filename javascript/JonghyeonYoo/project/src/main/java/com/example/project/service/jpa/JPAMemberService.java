package com.example.project.service.jpa;

import com.example.project.controller.vue.jpa.request.MemberRequest;
import com.example.project.entity.jpa.Member;

import java.util.Optional;

public interface JPAMemberService {
     void register(MemberRequest memberRequest) throws Exception;

     boolean login(MemberRequest memberRequest) throws Exception;
     boolean checkUserIdValidation(String userId) throws Exception;
    /*
    public List<Member> list() throws Exception;
     */

     Optional<Member> findByAuth(Long memberNo);
}