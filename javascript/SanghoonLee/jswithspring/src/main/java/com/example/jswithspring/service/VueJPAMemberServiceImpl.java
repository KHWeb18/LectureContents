package com.example.jswithspring.service;

import com.example.jswithspring.entity.Member;
import com.example.jswithspring.entity.VueMember;
import com.example.jswithspring.repository.VueJPAMemberRepository;
import com.example.jswithspring.repository.VueMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueJPAMemberServiceImpl implements VueJPAMemberService {

    @Autowired
    private VueJPAMemberRepository repository;

    @Override
    public void register(VueMember member) throws Exception {
        repository.save(member);
    }
}
