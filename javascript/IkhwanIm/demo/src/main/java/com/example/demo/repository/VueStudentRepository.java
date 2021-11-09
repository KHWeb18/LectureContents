package com.example.demo.repository;

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
public class VueStudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Student> list() throws Exception {
        List<Student> results = jdbcTemplate.query(
                "select student_no, name, student_grade, grades, reg_date from vuestudent " +
                        "where student_no > 0 order by student_no desc",

                new RowMapper<Student>() {
                    @SneakyThrows
                    @Override
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Student student = new Student();

                        student.setStudentNo(rs.getInt("student_no"));
                        student.setName(rs.getString("name"));
                        student.setStudentGrade(rs.getInt("student_grade"));
                        student.setGrades(rs.getString("grades"));

                        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        //board.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        student.setRegDate(rs.getDate("reg_date"));

                        return student;
                    }
                }
        );

        return results;
    }

}