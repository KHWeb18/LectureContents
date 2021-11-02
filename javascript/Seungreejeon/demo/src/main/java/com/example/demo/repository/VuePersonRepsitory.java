package com.example.demo.repository;


import com.example.demo.entity.Person;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class VuePersonRepsitory {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> getStudentScoreList() {
        String query = "select student_no, name, score, reg_date " +
                "from vuestudent where student_no > 0 order by student_no desc";
        List<Person> results = jdbcTemplate.query(query,

        new RowMapper<Person>() {
            @SneakyThrows
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();

                person.setStudentNo(rs.getInt("student_no"));
                person.setName(rs.getString("name"));
                person.setScore(rs.getInt("score"));
                person.setRegDate(rs.getDate("reg_date"));

                return person;
            }
        }
        );
        return results;
    }
}
