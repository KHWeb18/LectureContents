package com.example.demo.repository;

import com.example.demo.entity.Member;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@Repository
public class VueMemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Member member) throws Exception {
        String query = "insert into vuemember (email, password, name ) values (?, ?, ?)";

        jdbcTemplate.update(query, member.getEmail(), member.getPassword(), member.getName());
    }

    public void login(Member member) throws Exception {

        List<Member> results = jdbcTemplate.query(
                "select email, password from member where email = ?",

                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setEmail(rs.getString("email"));
                        member.setPassword(rs.getString("password"));

                        return member;
                    }
                }, member.getEmail());

        Member tmp = results.get(0);
        log.info("tmp: " + tmp);

        if (tmp.getPassword().equals(member.getPassword())) {
            log.info("Password Correct");
        } else {
            log.info("Password Incorrect");
        }
    }
    public List<Member> list() throws Exception {
        List<Member> results = jdbcTemplate.query(
                "select member_no, email, password, name, phoneNum, reg_date from member " +
                        "where member_no > 0 order by member_no desc",
                new RowMapper<Member>() {
                    @SneakyThrows
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setMemberNo(rs.getInt("member_no"));
                        member.setEmail(rs.getString("email"));
                        member.setPassword(rs.getString("password"));
                        member.setName(rs.getString("name"));
                        member.setPhoneNum(rs.getString("phoneNum"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


                        member.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        //System.out.println("rs.getDate(): " + rs.getTimestamp("reg_date"));
                        //System.out.println("rs.getDate(): " + rs.getDate("reg_date"));
                        //System.out.println("rs.getTime(): " + rs.getTime("reg_date"));

                        return member;
                    }
                }
        );

        return results;
    }
}