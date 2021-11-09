package com.example.SoloProject.repository;

import com.example.SoloProject.entity.Member;
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
public class MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Member member) {
        String query = "insert into member (name, id, pw) values (?, ?, ?)";

        jdbcTemplate.update(query, member.getName(), member.getId(), member.getPw());


    }

    public List<Member> list() throws Exception {

        List<Member> results = jdbcTemplate.query(
                "select member_no, id, pw, reg_date from member " +
                        "where member_no > 0 order by member_no desc",

                new RowMapper<Member>() {
                    @SneakyThrows
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setMemberNo(rs.getInt("member_no"));
                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        member.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return member;
                    }
                }
        );
        return results;
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
        log.info("tmp: " + tmp);

        if (tmp.getPw().equals(member.getPw())) {
            log.info("Password Correct");
        } else {
            log.info("Password Incorrect");
        }
    }

    public Member read (Integer memberNo) throws Exception {
        List<Member> results = jdbcTemplate.query(
                "select member_no, name, id, pw, reg_date from member where member_no = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setMemberNo(rs.getInt("member_no"));
                        member.setName(rs.getString("name"));
                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));
                        member.setRegDate(rs.getDate("reg_date"));

                        return member;
                    }
                }, memberNo);

        return results.isEmpty() ? null : results.get(0);
    }


    public void delete(Integer memberNo) throws Exception{
        String query = "delete from member where member_no=?";

        jdbcTemplate.update(query, memberNo);
    }

    public void update(Member member) throws Exception{
        String query = "update member set name = ?, id=?, pw=? where member_no=?";

        jdbcTemplate.update(query, member.getName(), member.getId(), member.getPw(), member.getMemberNo());
    }
}