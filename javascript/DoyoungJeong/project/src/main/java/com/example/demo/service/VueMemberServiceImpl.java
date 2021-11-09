package com.example.demo.service;

import com.example.demo.entity.VueMember;
import com.example.demo.repository.VueMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueMemberServiceImpl implements VueMemberService {

    @Autowired
    private VueMemberRepository repository;

    @Override
    public void register(VueMember member) throws Exception {
        repository.create(member);
    }

    @Override
    public void login(VueMember member) throws Exception {
        repository.login(member);
    }

    @Override
    public List<VueMember> list() throws Exception {
        return repository.list();
    }

    @Override
    public VueMember read(Integer memberNo) throws Exception {
        return repository.read(memberNo);
    }

    @Override
    public void modify(VueMember member) throws Exception {
        repository.update(member);
    }

    @Override
    public void remove(Integer member) throws Exception {
        repository.delete(member);
    }
}