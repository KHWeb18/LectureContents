package com.example.demo.service;

import com.example.demo.entity.VueMember;
import com.example.demo.repository.VueJPAMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class VueJPAMemberServiceImpl implements VueJPAMemberService {

    @Autowired
    VueJPAMemberRepository jpaSignUpRepository;

    @Override
    public void register(VueMember member) throws Exception {
        jpaSignUpRepository.save(member);
    }

    /*
    @Override
    public void login(Member member) throws Exception {
        repository.login(member);
    }
     */
    @Override
    public List<VueMember> lists() throws Exception {
        return jpaSignUpRepository.findAll();
    }
}