package com.example.Quiz.repository;

import com.example.Quiz.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> list() throws Exception {

        List<Student> results = jdbcTemplate.query(
                "select student_no, name, score from student " +
                        "where student_no > 0 order by student_no desc",
                new RowMapper<Student>() {
                    @Override
                    public Student mapRow(ResultSet rs, int i) throws SQLException {
                        Student student = new Student();

                        student.setStudentNo(rs.getInt("student_no"));
                        student.setName(rs.getString("name"));
                        student.setScore(rs.getInt("score"));

                        return student;
                    }
                }
        );
        return results;
    }
}
