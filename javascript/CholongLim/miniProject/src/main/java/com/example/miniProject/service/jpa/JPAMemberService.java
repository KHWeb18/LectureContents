package com.example.miniProject.service.jpa;

import com.example.miniProject.controller.member.request.MemberRequest;
import com.example.miniProject.entity.jpa.Member;

import java.util.Optional;

public interface JPAMemberService {
//    public void register(Member member) throws Exception;
    // 회원가입
    public void register(MemberRequest memberRequest) throws Exception;

    // 아이디 중복체크
    public boolean duplicateCheck(MemberRequest memberRequest) throws Exception;

    // 로그인
    public boolean login(MemberRequest memberRequest) throws Exception;


    public boolean checkUserIdValidation(String userId) throws Exception;

    public Optional<Member> findByAuth(Long memberNo);

    // 회원정보 수정


    // 회원 탈퇴


}