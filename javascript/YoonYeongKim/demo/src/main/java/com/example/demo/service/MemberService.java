package com.example.demo.service;

import com.example.demo.entity.Member;

import java.util.List;

public interface MemberService {
    public void signup(Member member) throws Exception;

//-------------------------------------------------------------------------

    public void login(Member member) throws Exception;

//-------------------------------------------------------------------------
// 가입한 사용자들의 모든  id를 for문을 사용해 출력

    public List<Member> list() throws Exception;

}