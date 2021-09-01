package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Together;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TogetherRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void modify(Together together) throws Exception {
        String query = "update together set title = ?, content = ? where board_no = ?";

        jdbcTemplate.update(query, together.getTitle(), together.getContent(), together.getBoardNo());
    }

    public void remove(Long boardNo) throws Exception {
        String query = "delete from together where board_no = ?";

        jdbcTemplate.update(query, boardNo);
    }
}
