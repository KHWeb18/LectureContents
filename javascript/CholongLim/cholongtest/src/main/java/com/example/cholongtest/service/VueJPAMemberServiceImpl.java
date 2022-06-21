package com.example.cholongtest.service;

import com.example.cholongtest.entity.VueMember;
import com.example.cholongtest.repository.VueJPAMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Slf4j
public class VueJPAMemberServiceImpl implements VueJPAMemberService {

    @Autowired
    private VueJPAMemberRepository repository;

    @Override
    public void register(VueMember vueMember) throws Exception {
        repository.save(vueMember);
    }
}