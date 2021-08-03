package com.example.miniProject.repository;

import com.example.miniProject.entity.Membership;
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
public class VueMembershipRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Membership membership) throws Exception {
        String query = "insert into membership (memName, memID, memPassword, phoneNum, memBirth) value(?,?,?,?,?)";

        jdbcTemplate.update(query, membership.getMemName(), membership.getMemID(), membership.getMemPassword(),
                            membership.getPhoneNum(), membership.getMemBirth());
    }

    public void login(Membership membership) throws Exception {

        List<Membership> results = jdbcTemplate.query(
                "select memID, memPassword from membership where memID = ?",

                new RowMapper<Membership>() {
                    @Override
                    public Membership mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Membership membership = new Membership();

                        membership.setMemID(rs.getString("memID"));
                        membership.setMemPassword(rs.getString("memPassword"));

                        return membership;
                    }
                }, membership.getMemID());

        Membership tmp = results.get(0);
        log.info("tmp: " + tmp);

        if (tmp.getMemPassword().equals(membership.getMemPassword())) {
            log.info("Password Correct");
        } else {
            log.info("Password Incorrect");
        }
    }

    public List<Membership> list() throws Exception {
        List<Membership> results = jdbcTemplate.query(
                "select membership_no, memName, memID, memPassword,phoneNum, memBirth, reg_date from membership " +
                        "where membership_no > 0 order by membership_no desc",

                new RowMapper<Membership>() {
                    @SneakyThrows
                    @Override
                    public Membership mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Membership membership = new Membership();

                        membership.setMembershipNo(rs.getInt("membership_no"));
                        membership.setMemName(rs.getString("memName"));
                        membership.setMemID(rs.getString("memID"));
                        membership.setMemPassword(rs.getString("memPassword"));
                        membership.setPhoneNum(rs.getString("phoneNum"));
                        membership.setMemBirth(rs.getString("memBirth"));

                        return membership;
                    }
                }
        );

        return results;
    }
}
