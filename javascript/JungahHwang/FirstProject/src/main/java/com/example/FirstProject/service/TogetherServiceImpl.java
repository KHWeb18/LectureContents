package com.example.FirstProject.service;

import com.example.FirstProject.entity.Together;
import com.example.FirstProject.repository.TogetherJPARepository;
import com.example.FirstProject.repository.TogetherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class TogetherServiceImpl implements TogetherService {

    @Autowired
    private TogetherJPARepository jpaRepository;

    @Autowired
    private TogetherRepository repository;

    @Override
    public void register(Together together) throws Exception {
        jpaRepository.save(together);
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
    public void modify(Together together) throws Exception {

        repository.modify(together);
    }

    @Override
    public void remove(Long boardNo) throws Exception {
        repository.remove(boardNo);
    }
}
