package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RecordRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void modify(Record record) throws Exception {
        String query = "update record set food = ?, exercise = ?, weight = ? where date = ?";

        jdbcTemplate.update(query, record.getFood(), record.getExercise(), record.getWeight(), record.getDate());
    }

    public void remove(String date) throws Exception {
        String query = "delete from record where date = ?";

        jdbcTemplate.update(query, date);
    }
}
