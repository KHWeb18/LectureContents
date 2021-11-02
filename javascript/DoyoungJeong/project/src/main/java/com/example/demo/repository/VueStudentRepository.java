package com.example.demo.repository;

import com.example.demo.entity.VueStudent;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VueStudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VueStudent> list() throws Exception {
        List<VueStudent> results = jdbcTemplate.query(
                "select student_no, name, reading, math, english from vuestudent " +
                        "where student_no > 0 order by student_no asc",
                new RowMapper<VueStudent>() {
                    @SneakyThrows
                    @Override
                    public VueStudent mapRow(ResultSet rs, int rowNum) throws SQLException {
                        VueStudent student = new VueStudent();

                        student.setName(rs.getString("name"));
                        student.setReading(rs.getInt("reading"));
                        student.setMath(rs.getInt("math"));
                        student.setEnglish(rs.getInt("english"));

                        return student;
                    }
                }
        );
        return results;
    }
}
