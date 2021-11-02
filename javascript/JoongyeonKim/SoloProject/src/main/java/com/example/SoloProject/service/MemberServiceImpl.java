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
    public void signup(Member member) {
        repository.create(member);
    }

    @Override
    public void login(Member member) throws Exception {
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