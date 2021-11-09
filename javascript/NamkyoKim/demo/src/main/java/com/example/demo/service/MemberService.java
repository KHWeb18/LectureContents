package com.example.demo.service;

import com.example.demo.eutity.Member;

import java.util.List;

public interface MemberService {

    public void join(Member member) throws Exception;

    public List<Member> list() throws Exception;

    public void login(Member member) throws Exception;

    public Member read(Integer memberNo) throws Exception;

    public void remove(Integer memberNo) throws Exception;

    public void modify(Member member)throws Exception;


}
