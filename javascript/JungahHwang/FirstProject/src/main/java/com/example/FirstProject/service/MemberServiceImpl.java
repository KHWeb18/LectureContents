package com.example.FirstProject.service;

import com.example.FirstProject.entity.Member;
import com.example.FirstProject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public void signup(Member member) throws Exception{
        repository.create(member);
    }
    @Override
    public void login(Member member) throws Exception{
        repository.login(member);
    }
    @Override
    public Member myPage(String pw) throws Exception {
        return repository.myPage(pw);

    }
}
