package com.example.projectTest.service;


import com.example.projectTest.entity.Member;
import com.example.projectTest.repository.VueMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueMemberServiceImpl implements VueMemberService {

    @Autowired
    private VueMemberRepository repository;

    @Override
    public void register(Member member) throws Exception {
        repository.create(member);
    }

    @Override
    public List<Member> list() throws Exception {
        return repository.list();
    }

    @Override
    public Member read(Integer memberNo) throws Exception {
        return repository.read(memberNo);
    }

    @Override
    public void remove(Integer memberNo) throws Exception {
        repository.delete(memberNo);
    }

    @Override
    public void modify(Member member) throws Exception {
        repository.update(member);
    }
}