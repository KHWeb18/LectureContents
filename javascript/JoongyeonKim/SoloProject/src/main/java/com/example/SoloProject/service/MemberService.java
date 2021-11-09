package com.example.SoloProject.service;

import com.example.SoloProject.entity.Member;

import java.util.List;

public interface MemberService {
    public void signup(Member member);

    public void login(Member member) throws Exception;

    public List<Member> list() throws Exception;

    public Member read(Integer memberNo) throws Exception;

    public void remove(Integer memberNo) throws Exception;

    public void modify(Member member) throws Exception;
}
