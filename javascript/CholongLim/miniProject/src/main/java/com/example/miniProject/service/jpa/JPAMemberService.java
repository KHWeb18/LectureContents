package com.example.miniProject.service.jpa;

import com.example.miniProject.controller.member.request.MemberRequest;
import com.example.miniProject.controller.member.request.UserRequest;
import com.example.miniProject.entity.jpa.Member;

import java.util.List;
import java.util.Optional;

public interface JPAMemberService {

    public void register(MemberRequest memberRequest) throws Exception;

    public boolean duplicateCheck(MemberRequest memberRequest) throws Exception;

    public boolean login(MemberRequest memberRequest) throws Exception;

    public boolean checkUserIdValidation(String userId) throws Exception;

    public Optional<Member> findByAuth(Long memberNo);

    public Member user(String userId) throws Exception;

    public void removeUser(Long memberNo) throws Exception;



}