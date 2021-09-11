package com.example.FirstProject.service;

import com.example.FirstProject.entity.Member;
import com.example.FirstProject.request.MemberDto;

import java.util.Optional;

public interface MemberService {
   //public void signup(Member member) throws Exception;
   public Member signup(MemberDto memberDto) throws Exception;
   public boolean login(Member member) throws Exception;
   public boolean validationId(String id) throws Exception;
   public Optional<Member> userInfo(String id) throws Exception;
   public Member findById(String id) throws Exception;
   public void modify(Member member, MemberDto memberDto) throws Exception;
   public void remove(Member member) throws Exception;
}
