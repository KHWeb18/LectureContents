package com.example.FirstProject.service;

import com.example.FirstProject.entity.Recommend;
import com.example.FirstProject.repository.RecommendJPARepository;
import com.example.FirstProject.repository.RecommendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private RecommendJPARepository jpaRepository;

    @Autowired
    private RecommendRepository repository;

    @Override
    public void register(Recommend recommend) throws Exception {
        jpaRepository.save(recommend);
    }

    @Override
    public List<Object[]> lists() throws Exception {
        return  jpaRepository.lists();
    }

    @Override
    public List<Object[]> read(Long boardNo) throws Exception {
        return jpaRepository.read(boardNo);
    }

    @Override
    public void modify(Recommend recommend) throws Exception {

        repository.modify(recommend);
    }

    @Override
    public void remove(Long boardNo) throws Exception {
        repository.remove(boardNo);
    }
}
