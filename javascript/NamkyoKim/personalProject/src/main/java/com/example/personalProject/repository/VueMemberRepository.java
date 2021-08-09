package com.example.personalProject.repository;

import com.example.personalProject.eutity.Member;
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
        String query = "insert into vuemember (id, pw) values " +
                "(?, ?)";

        jdbcTemplate.update(query, member.getId(), member.getPw());
    }
    public List<Member>list() throws Exception{
        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<Member> results = jdbcTemplate.query(
                "select member_no, user_id, user_pass, name, sex, phone_no, dateOfBirth, join_date  from member " +
                        "where member_no > 0 order by member_no desc",
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 덛어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Member>() {
                    @SneakyThrows
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();


                        member.setMemberNo(rs.getInt("member_no"));
                        member.setId(rs.getString("user_id"));
                        member.setPw(rs.getString("user_pass"));
                        member.setSex(rs.getString("sex"));
                        member.setPhoneNo(rs.getString("phone_no"));
                        member.setName(rs.getString("name"));
                        member.setBirth(rs.getString("dateOfBirth"));

                        //board.setRegDate(rs.getTimestamp("reg_date"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        member.setJoinDate(sdf.parse(rs.getDate("join_date") + " " + rs.getTime("join_date")));




                       // System.out.println("rs.getDate():" + rs.getDate("reg_date"));

                        return member;
                    }
                }
        );

        return results;
    }
    public void login(Member member) throws Exception {

        List<Member> results = jdbcTemplate.query(
                "select user_id, user_pass from member where user_id = ?",

                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setId(rs.getString("user_id"));
                        member.setPw(rs.getString("user_pass"));

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

    public Member read(Integer memberNo) throws Exception{
        List<Member> results = jdbcTemplate.query(
                "select member_no, user_id, user_pass, sex, phone_no, name, dateOfBirth, join_date " +
                        " from member where member_no = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setMemberNo(rs.getInt("member_no"));
                        member.setId(rs.getString("user_id"));
                        member.setPw(rs.getString("user_pass"));
                        member.setSex(rs.getString("sex"));
                        member.setPhoneNo(rs.getString("phone_no"));
                        member.setName(rs.getString("name"));
                        member.setBirth(rs.getString("dateOfBirth"));
                        member.setJoinDate(rs.getDate("join_date"));

                        return member;
                    }
                }, memberNo);

        return results.isEmpty() ? null : results.get(0);
    }
    public void delete(Integer memberNo) throws Exception{
        String query = "delete from member where member_no = ?";

        jdbcTemplate.update(query, memberNo);
    }

    public void update(Member member)throws Exception{
        String query = "update member set user_id = ?, user_pass = ?, " +
                "sex = ?, phone_no = ?, name = ?, dateOfBirth = ? where member_no = ?";

        jdbcTemplate.update(query, member.getId(), member.getPw(),
                member.getName(),member.getBirth(), member.getPhoneNo());
    }
}