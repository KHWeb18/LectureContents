package com.example.demo.repository;

import com.example.demo.entity.Board;
import com.example.demo.entity.Student;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VueStudentScoreRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getStudentScoreList() throws Exception {
        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<Student> results = jdbcTemplate.query(
                "select student_no, name, score, reg_date from vuestudent " +
                        "where student_no > 0 order by student_no desc",
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Student>() {
                    @SneakyThrows
                    @Override
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Student student = new Student();


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
