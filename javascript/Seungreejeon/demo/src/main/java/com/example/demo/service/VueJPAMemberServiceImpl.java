package com.example.demo.service;


import com.example.demo.entity.VueMember;
import com.example.demo.repository.VueJPAMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueJPAMemberServiceImpl implements VueJPAMemberService{

    @Autowired
    VueJPAMemberRepository repository;

    @Override
    public void register(VueMember vueMember) throws Exception {
        repository.save(vueMember);
    }
}

