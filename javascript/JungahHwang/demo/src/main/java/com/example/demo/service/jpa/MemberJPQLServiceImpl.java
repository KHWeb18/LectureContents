package com.example.demo.service.jpa;

import com.example.demo.entity.jpa.MemberJPQL;
import com.example.demo.repository.jpa.MemberJPQLRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class MemberJPQLServiceImpl implements MemberJPQLService {

    @Autowired
    private MemberJPQLRepository repository;

    @Override
    public List<MemberJPQL> findByJPQL() throws Exception {
        return repository.findByJPQL("go");
    }

    @Override
    public List<Object[]> findSpecificJPQL() throws Exception {
        return repository.findSpecificJPQL("go");
    }
}


























