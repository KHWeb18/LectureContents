package com.example.demo.service;

import com.example.demo.entity.VueJPAMember;
import com.example.demo.repository.VueJPAMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueJPAMemberServiceImpl implements VueJPAMemberService{

    @Autowired
    private VueJPAMemberRepository repository;

    @Override
    public void register(VueJPAMember member) throws Exception {
        repository.save(member);
    }
}
