package com.example.demo.repository;

import com.example.demo.entity.VueMember;
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

    public void create(VueMember member) throws Exception {
        String query = "insert into vuemember (id, pw, name, birthDay, address, party, comment) values (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, member.getId(), member.getPw(), member.getName(), member.getBirthDay(),
                member.getAddress(), member.getParty(), member.getComment());
    }

    public void login(VueMember member) throws Exception {

        List<VueMember> results = jdbcTemplate.query(
                "select id, pw from vuemember where id = ?",

                new RowMapper<VueMember>() {
                    @Override
                    public VueMember mapRow(ResultSet rs, int rowNum) throws SQLException {
                        VueMember member = new VueMember();

                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));

                        return member;
                    }
                }, member.getId());

        VueMember tmp = results.get(0);
        log.info("tmp: " + tmp);

        if (tmp.getPw().equals(member.getPw())) {
            log.info("Password Correct");
        } else {
            log.info("Password Incorrect");
        }
    }

    public List<VueMember> list() throws Exception {
        List<VueMember> results = jdbcTemplate.query(
                "select member_no, id, pw, name, birthday, address, party, comment, reg_date from vuemember " +
                        "where member_no > 0 order by member_no desc",
                new RowMapper<VueMember>() {
                    @SneakyThrows
                    @Override
                    public VueMember mapRow(ResultSet rs, int rowNum) throws SQLException {
                        VueMember member = new VueMember();

                        member.setMemberNo(rs.getInt("member_no"));
                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));
                        member.setName(rs.getString("name"));
                        member.setBirthDay(rs.getInt("birthday"));
                        member.setAddress(rs.getString("address"));
                        member.setParty(rs.getString("party"));
                        member.setComment(rs.getString("comment"));
                        member.setRegDate(rs.getDate("reg_date"));

//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        member.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return member;
                    }
                }
        );

        return results;
    }

    public VueMember read (Integer memberNo) throws Exception {
        List<VueMember> results = jdbcTemplate.query(
                "select member_no, id, pw, name, birthday, address, party, comment, reg_date from vuemember where member_no = ?",
                new RowMapper<VueMember>() {
                    @Override
                    public VueMember mapRow(ResultSet rs, int rowNum) throws SQLException {
                        VueMember member = new VueMember();

                        member.setMemberNo(rs.getInt("member_no"));
                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));
                        member.setName(rs.getString("name"));
                        member.setBirthDay(rs.getInt("birthday"));
                        member.setAddress(rs.getString("address"));
                        member.setParty(rs.getString("party"));
                        member.setComment(rs.getString("comment"));
                        member.setRegDate(rs.getDate("reg_date"));

                        return member;
                    }
                }, memberNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer memberNo) throws Exception {
        String query = "delete from vuemember where member_no = ?";

        jdbcTemplate.update(query, memberNo);
    }

    public void update(VueMember member) throws Exception {
        String query = "update vuemember set id = ?, pw = ?, name = ?, birthday = ?, address = ?, party = ?, comment = ? where member_no = ?";

        jdbcTemplate.update(query, member.getId(), member.getPw(), member.getName(), member.getBirthDay(), member.getAddress(),
                member.getParty(), member.getComment(), member.getMemberNo());
    }
}