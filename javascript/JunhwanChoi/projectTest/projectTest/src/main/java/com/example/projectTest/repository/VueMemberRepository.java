package com.example.projectTest.repository;

import com.example.projectTest.entity.Member;
import lombok.SneakyThrows;
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
public class VueMemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Member member) throws Exception {
        String query = "insert into vueproject (id, password, username, birth) values (?, ?, ?, ?)";

        jdbcTemplate.update(query, member.getId(),member.getPassword(),member.getUsername(),member.getBirth());

    }

    public List<Member> list() throws Exception {

        List<Member> results = jdbcTemplate.query(
                "select member_no, id, password, username, birth, reg_date from vueproject " +
                        "where member_no > 0 order by member_no desc",

                new RowMapper<Member>() {
                    @SneakyThrows
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();


                        member.setMemberNo(rs.getInt("member_no"));
                        member.setId(rs.getString("id"));
                        member.setPassword(rs.getString("password"));
                        member.setUsername(rs.getString("username"));
                        member.setBirth(rs.getInt("birth"));

                        member.setRegDate(rs.getDate("reg_date"));

                        return member;
                    }
                }
        );

        return results;
    }

    public Member read (Integer memberNo) throws Exception {
        List<Member> results = jdbcTemplate.query(
                "select member_no, id, password, username, birth, " +
                        "reg_date from vueproject where member_no = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();


                        member.setMemberNo(rs.getInt("member_no"));
                        member.setId(rs.getString("id"));
                        member.setPassword(rs.getString("password"));
                        member.setUsername(rs.getString("username"));
                        member.setBirth(rs.getInt("birth"));

                        member.setRegDate(rs.getDate("reg_date"));

                        return member;
                    }
                }, memberNo);

        return results.isEmpty() ? null : results.get(0);
    }
    public void delete(Integer memberNo) throws Exception {
        String query = "delete from vueproject where member_no = ?";
        jdbcTemplate.update(query, memberNo);
    }

    public void update(Member member) throws Exception {
        String query = "update vueproject set password = ? where member_no = ?";
        jdbcTemplate.update(query, member.getPassword(), member.getMemberNo());
    }


}
