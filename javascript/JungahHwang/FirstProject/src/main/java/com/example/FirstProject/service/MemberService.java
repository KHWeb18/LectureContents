package com.example.FirstProject.service;

import com.example.FirstProject.entity.Member;
import com.example.FirstProject.request.MemberDto;

import java.util.Optional;

public interface MemberService {
   Member signup(MemberDto memberDto) throws Exception;
   boolean login(Member member) throws Exception;
   boolean validationId(String id) throws Exception;
   Optional<Member> userInfo(String id) throws Exception;
   Member findById(String id) throws Exception;
   void modify(Member member, MemberDto memberDto) throws Exception;
   void remove(Member member) throws Exception;
}
