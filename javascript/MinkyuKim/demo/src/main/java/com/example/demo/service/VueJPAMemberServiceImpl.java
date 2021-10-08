package com.example.demo.service;


import com.example.demo.entity.VueMember;
import com.example.demo.repository.VueJPAMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class VueJPAMemberServiceImpl implements VueJPAMemberService {

    @Autowired
    private VueJPAMemberRepository repository;

    //save는 jpa 회원가입 전용
    // repository의 extends에 맵핑되는 역할. 즉 데이터를 전달
    @Override
    public void register(VueMember member) throws Exception {
        repository.save(member);
    }


}