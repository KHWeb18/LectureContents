package com.example.springTest.service.jpa;

import com.example.springTest.controller.vue.jpa.request.MemberRequest;
import com.example.springTest.entity.jpa.Member;
import com.example.springTest.entity.jpa.MemberAuth;
import com.example.springTest.entity.jpa.TestMember;
import com.example.springTest.repository.jpa.JPAMemberAuthRepository;
import com.example.springTest.repository.jpa.JPAMemberRepository;
import com.example.springTest.repository.jpa.JPATestMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPATestMemberServiceImpl implements JPATestMemberService {

    @Autowired
    private JPATestMemberRepository memberRepository;

    @Override
    public List<TestMember> findByJPQL() throws Exception {
        return memberRepository.findByJPQL("test1");
    }

    @Override
    public List<Object[]> findSpecificByJPQL() throws Exception {
        return memberRepository.findSpecificByJPQL("test1");
    }


}
