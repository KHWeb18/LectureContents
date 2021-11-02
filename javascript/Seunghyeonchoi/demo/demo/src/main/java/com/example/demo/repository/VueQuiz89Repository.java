package com.example.demo.repository;

import com.example.demo.entity.Quiz89;
import org.springframework.stereotype.Repository;

@Repository
public class VueQuiz89Repository {

    public Quiz89 getArea() {
        return new Quiz89();
    }
}