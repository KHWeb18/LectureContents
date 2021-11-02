package com.example.jswithspring.service;

import com.example.jswithspring.entity.Member;
import com.example.jswithspring.repository.MemberRepository;
import com.example.jswithspring.repository.VueMemberRepository;
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

   /* @Override
    public void login(Member member) throws Exception {
        repository.login(member);
    }

    @Override
    public List<Member> list() throws Exception {
        return repository.list();
    }*/
}
