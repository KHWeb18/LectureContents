package com.example.cholongtest.repository;

import com.example.cholongtest.entity.Student;
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

    public List<Student> getStudentScoreList() throws Exception {

        List<Student> results = jdbcTemplate.query(
                "select student_no, name, grade, reg_date from vuestudent " +
                        "where student_no > 0 order by student_no desc",

                new RowMapper<Student>() {
                    @SneakyThrows
                    @Override
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Student student = new Student();

                        student.setStudentNo(rs.getInt("student_no"));
                        student.setName(rs.getString("name"));
                        student.setGrade(rs.getInt("grade"));
                        student.setRegDate(rs.getDate("reg_date"));

                        return student;
                    }

                }
        );

        return results;
    }
}