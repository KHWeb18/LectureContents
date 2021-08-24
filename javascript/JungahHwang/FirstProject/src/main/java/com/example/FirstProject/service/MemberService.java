package com.example.FirstProject.service;

import com.example.FirstProject.entity.Member;

import java.util.Optional;

public interface MemberService {
   public void signup(Member member) throws Exception;
   public boolean login(Member member) throws Exception;
   public boolean validationId(String id) throws Exception;
   public Optional<Member> userInfo(String id) throws Exception;
}
