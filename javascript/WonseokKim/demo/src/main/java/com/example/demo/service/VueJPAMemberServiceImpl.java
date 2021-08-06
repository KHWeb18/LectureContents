
package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.VueMember;
import com.example.demo.repository.VueJPAMemberRepository;
import com.example.demo.repository.VueMemberRepository;
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
