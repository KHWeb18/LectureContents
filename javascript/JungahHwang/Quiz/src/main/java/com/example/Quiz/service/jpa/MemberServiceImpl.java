package com.example.Quiz.service.jpa;

import com.example.Quiz.entity.jpa.Member;
import com.example.Quiz.repository.jpa.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository repository;

    @Override
    public void signup(Member member) throws Exception {
        repository.save(member);
    }
}


























