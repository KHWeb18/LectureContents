package com.example.demo.repository;

import com.example.demo.entity.Member;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class VueMemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Member member) throws Exception {
        String query = "insert into vuemember (id, pw) values (?, ?)";

        jdbcTemplate.update(query, member.getId(), member.getPw());
    }

    public void login(Member member) throws Exception {

        List<Member> results = jdbcTemplate.query(
                "select id, pw from member where id = ?",

                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));

                        return member;
                    }
                }, member.getId());

        Member tmp = results.get(0);
       // log.info("tmp: " + tmp);

        if (tmp.getPw().equals(member.getPw())) {
          //  log.info("Password Correct");
        } else {
           // log.info("Password Incorrect");
        }
    }

    public List<Member> list() throws Exception {
        List<Member> results = jdbcTemplate.query(
                "select memberNo, id, pw, regDate from member " +
                        "where memberNo > 0 order by memberNo desc",
                new RowMapper<Member>() {
                    @SneakyThrows
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setMemberNo(rs.getInt("memberNo"));
                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        member.setRegDate(sdf.parse(rs.getDate("regDate") + " " + rs.getTime("regDate")));

                        return member;
                    }
                }
        );

        return results;
    }
}
