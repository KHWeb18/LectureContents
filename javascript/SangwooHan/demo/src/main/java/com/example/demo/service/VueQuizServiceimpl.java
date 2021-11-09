package com.example.demo.service;

import com.example.demo.entity.Quiz;
import com.example.demo.repository.VueProductRepository;
import com.example.demo.repository.VueQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueQuizServiceimpl implements VueQuizService{

    @Autowired
    private VueQuizRepository repository;
    @Override
    public void register(Quiz quiz) throws Exception {
        repository.create(quiz);
    }
}
