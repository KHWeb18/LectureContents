package com.example.demo.service;

import com.example.demo.entity.Quiz89;
import com.example.demo.repository.VueQuiz89Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueQuiz89ServiceImpl implements VueQuiz89Service {

    @Autowired
    private VueQuiz89Repository repository;

    @Override
    public Quiz89 getArea() {
        return repository.getArea();
    }
}