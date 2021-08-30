package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Recommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RecommendRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void modify(Recommend recommend) throws Exception {
        String query = "update recommend set id = ?, title = ?, content = ? where board_no = ?";

        jdbcTemplate.update(query, recommend.getId(), recommend.getTitle(), recommend.getContent(), recommend.getBoardNo());
    }
}
