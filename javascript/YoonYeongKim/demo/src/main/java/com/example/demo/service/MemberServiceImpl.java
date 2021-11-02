package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public void signup(Member member) throws Exception {
        repository.create(member);
    }

    @Override
    public void login(Member member) throws Exception {
        repository.login(member);
    }

    //---------------------------------------------------------
    // 가입한 사용자들의 모든  id를 for문을 사용해 출력

    @Override
    public List<Member> list() throws Exception {
        return repository.list();
    }
}