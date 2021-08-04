package com.example.Quiz.service;

import com.example.Quiz.entity.MemberJpa;
import com.example.Quiz.repository.MemberJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Slf4j
public class MemberJpaServiceImpl implements MemberJpaService {

    @Autowired
    MemberJpaRepository repository;

    @Override
    public void signup(MemberJpa member) throws Exception {
        repository.save(member);
    }
}


























