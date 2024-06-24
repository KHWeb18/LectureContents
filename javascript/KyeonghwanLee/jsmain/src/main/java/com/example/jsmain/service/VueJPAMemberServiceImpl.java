package com.example.jsmain.service;


import com.example.jsmain.entity.VueMember;
import com.example.jsmain.repository.VueJPAMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Slf4j
public class VueJPAMemberServiceImpl implements VueJPAMemberService {

    @Autowired
    VueJPAMemberRepository repository;

    @Override
    public void register(VueMember member) throws Exception{
        repository.save(member);
    }
}
