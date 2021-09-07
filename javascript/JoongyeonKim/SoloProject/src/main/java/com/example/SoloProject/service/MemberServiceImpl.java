package com.example.SoloProject.service;

import com.example.SoloProject.entity.Member;
import com.example.SoloProject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public void register(Member member) throws Exception {
        repository.save(member);
    }

    /*
    @Override
    public void login(Member member) throws Exception {
        repository.login(member);
    }

    @Override
    public List<Member> lists() throws Exception {
        return repository.findAll();
    }
     */
}