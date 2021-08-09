package com.example.personalProject.service.jpa;

import com.example.personalProject.controller.jpa.request.MemberRequest;
import com.example.personalProject.eutity.jpa.Member;
import com.example.personalProject.eutity.jpa.MemberAuth;
import com.example.personalProject.eutity.jpa.TestMember;
import com.example.personalProject.repository.jpa.JPATestMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPATestMemberServiceImpl implements JPATestMemberService {

    @Autowired
    private JPATestMemberRepository memberRepository;

    @Override
    public List<TestMember> findByJPQL() throws Exception {
        return memberRepository.findByJPQL("test2");
    }

    @Override
    public List<Object[]> findSpecificByJPQL() throws Exception {
        return memberRepository.findSpecificByJPQL("test3");
    }
}
