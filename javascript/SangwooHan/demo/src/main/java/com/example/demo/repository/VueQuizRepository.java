package com.example.demo.repository;

import com.example.demo.entity.Product;
import com.example.demo.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VueQuizRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void create(Quiz quiz) throws Exception {
        String query = "insert into vuequiz (rowss, height) values (?, ?)";

        jdbcTemplate.update(query, quiz.getRowss(),quiz.getHeight());
    }
}
