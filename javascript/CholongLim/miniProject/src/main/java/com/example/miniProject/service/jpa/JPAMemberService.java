package com.example.miniProject.service.jpa;

import com.example.miniProject.controller.member.request.MemberRequest;
import com.example.miniProject.entity.jpa.Member;

public interface JPAMemberService {
//    public void register(Member member) throws Exception;
    // 회원가입
    public void register(Member member) throws Exception;

    // 아이디 중복체크
    public boolean duplicateCheck(Member member) throws Exception;

    // 로그인
    public boolean login(MemberRequest memberRequest) throws Exception;


    public boolean checkUserIdValidation(String userId) throws Exception;

    // 회원정보 수정


    // 회원 탈퇴


}