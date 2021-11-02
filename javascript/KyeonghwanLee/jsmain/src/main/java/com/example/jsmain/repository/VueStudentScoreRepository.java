package com.example.jsmain.repository;

import com.example.jsmain.entity.Board;
import com.example.jsmain.entity.Dungeon;
import com.example.jsmain.entity.Student;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class VueStudentScoreRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getStudentScoreList() throws Exception {

        List<Student> results = jdbcTemplate.query(
                "select student_no, name, score, reg_date from vuestudent " +
                        "where student_no > 0 order by student_no desc",

                new RowMapper<Student>() {
                    @SneakyThrows
                    @Override
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Student student = new Student();

                        // rs.getInt()는 DB에 있는 정수형 정보를 얻어옴
                        student.setStudentNo(rs.getInt("student_no"));
                        student.setName(rs.getString("name"));
                        student.setScore(rs.getInt("score"));
                        student.setRegDate(rs.getDate("reg_date"));

                        return student;
                    }
                }
        );

        return results;
    }

}