package com.example.demo.service.jpa;

import com.example.demo.controller.jpa.request.MemberRequest;
import com.example.demo.entity.jpa.Member;

import java.util.Optional;

public interface MemberService {
    public void register(MemberRequest memberRequest) throws Exception;
    public Optional<Member> findByAuth(Long memberNo) throws Exception;
    public boolean login(MemberRequest memberRequest) throws Exception;
    public boolean checkUserIdValidation(String id) throws Exception;
}
