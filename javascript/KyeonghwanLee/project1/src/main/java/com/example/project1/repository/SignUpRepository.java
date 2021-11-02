package com.example.project1.repository;


import com.example.project1.entity.Member;
import com.example.project1.entity.Member;
import com.example.project1.entity.Product;
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
public class SignUpRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create (Member member) throws Exception {
        String query = "insert into member (id, pw, name, phoneNumber, email, address) values (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, member.getId(), member.getPw(), member.getName(), member.getPhoneNumber(), member.getEmail(), member.getAddress());
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
        /*
        public List<Member> list() throws Exception {
            // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
            // results엔 DB에서 얻어온 행 정보들이 들어있다.
            List<Member> results = jdbcTemplate.query(
                    "select member_no, id, pw, reg_date from member " +
                            "where member_no > 0 order by member_no desc",
                    // Row: 행
                    // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                    // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
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

            return results;*/
    }

    public List<Member> memberList() throws Exception {
        List<Member> results = jdbcTemplate.query(
                "select member_no, id, pw, name, phoneNumber, email, address, reg_date from member " +
                        "where member_no > 0 order by member_no desc",
                new RowMapper<Member>() {
                    @SneakyThrows
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setMemberNo(rs.getInt("member_no"));
                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));
                        member.setName(rs.getString("name"));
                        member.setPhoneNumber(rs.getString("phoneNumber"));
                        member.setEmail(rs.getString("email"));
                        member.setAddress(rs.getString("address"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        member.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return member;
                    }
                }
        );

        return results;
    }
}
