package com.example.jsmain.service;

import com.example.jsmain.entity.VueMember;
import com.example.jsmain.repository.VueJPAMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueJPAMemberServiceImpl implements VueJPAMemberService {

    @Autowired
    private VueJPAMemberRepository repository;

    @Override
    public void register(VueMember member) throws Exception {
        repository.save(member);
    }
}


