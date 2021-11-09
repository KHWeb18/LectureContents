package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Member member) throws Exception{
        String query = "insert into join_mem (id_no, id, pw, name, tel, addr, gender, email, birth) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, member.getIdNo(), member.getId(),member.getPw(),member.getName(),
                member.getTel(), member.getAddr(), member.getGender(), member.getEmail(), member.getBirth());
    }
    public void login(Member member) throws Exception{
        List<Member> result = jdbcTemplate.query(
                "select id, pw from join_mem where id = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));

                        return member;
                    }
                }, member.getId()
        );
        Member tmp = result.get(0);
        log.info("tmp: " + tmp);

        if (tmp.getPw().equals(member.getPw())){
            log.info("Password Correct");
        }else {
            log.info("Password Incorrect");
        }
    }
    public Member myPage(String pw) throws Exception{
        List<Member> result = jdbcTemplate.query(
                "select id, pw, name, tel, addr, gender, email, birth from join_mem where id = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setId(rs.getString("id"));
                        member.setId(rs.getString("pw"));
                        member.setId(rs.getString("name"));
                        member.setId(rs.getString("tel"));
                        member.setId(rs.getString("addr"));
                        member.setId(rs.getString("gender"));
                        member.setId(rs.getString("email"));
                        member.setId(rs.getString("birth"));

                        return member;
                    }
                }, pw
        );
        return result.get(0);
    }
}
