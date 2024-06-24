package com.example.demo.service.jpa;

import com.example.demo.entity.jpa.TestMember;
import com.example.demo.repository.jpa.JPATestMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPATestMemberServiceImpl implements JPATestMemberService {

    @Autowired
    private JPATestMemberRepository memberTestRepository;

    @Override
    public List<TestMember> findByJPQL() throws Exception {
        return memberTestRepository.findByJPQL("hihi");
    }

    @Override
    public List<Object[]> findSpecificByJPQL() throws Exception {
        return memberTestRepository.findSpecificByJPQL("hihi");
    }
}