package com.example.personalProject.service.jpa;

import com.example.personalProject.controller.jpa.request.MemberRequest;
import com.example.personalProject.eutity.jpa.Member;

import java.util.List;
import java.util.Optional;

public interface JPAMemberService {

    public void register(MemberRequest memberRequest) throws Exception;
/*
    public List<Member> list() throws Exception;

    public void login(Member member) throws Exception;

    public Member read(Integer memberNo) throws Exception;

    public void remove(Integer memberNo) throws Exception;

    public void modify(Member member)throws Exception;

*/
    public Optional<Member> findByAuth(Long auth);

}
