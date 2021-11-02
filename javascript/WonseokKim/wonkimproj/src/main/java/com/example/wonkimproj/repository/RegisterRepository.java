package com.example.wonkimproj.repository;

import com.example.wonkimproj.entity.Register;
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
public class RegisterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Register register) throws Exception {
        String query = "insert into user (id, pw, name, pn, pn2, email, email2, addr, addr2, addr3) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                query, register.getId(), register.getPw(), register.getName(),
                register.getPn(), register.getPn2(), register.getEmail(), register.getEmail2(),
                register.getAddr(), register.getAddr2(), register.getAddr3());
    }

    public List<Register> list() throws Exception {
        List<Register> results = jdbcTemplate.query(
                "select user_no, id, pw, name, pn, pn2, email, email2, addr, addr2, addr3, reg_date from user " +
                        "where user_no > 0 order by user_no desc",

                new RowMapper<Register>() {
                    @SneakyThrows
                    @Override
                    public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Register register = new Register();

                        // rs.getInt()는 DB에 있는 정수형 정보를 얻어옴
                        register.setUserNo(rs.getInt("user_no"));
                        register.setId(rs.getString("id"));
                        register.setPw(rs.getString("pw"));
                        register.setName(rs.getString("name"));
                        register.setPn(rs.getString("pn"));
                        register.setPn2(rs.getString("pn2"));
                        register.setEmail(rs.getString("email"));
                        register.setEmail2(rs.getString("email2"));
                        register.setAddr(rs.getString("addr"));
                        register.setAddr2(rs.getString("addr2"));
                        register.setAddr3(rs.getString("addr3"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        register.setRegDate(sdf.parse(rs.getDate("reg_date")
                                + " " + rs.getTime("reg_date")));

                        return register;
                    }
                }
        );

        return results;
    }

    public Register read (Integer userNo) throws Exception {
        List<Register> results = jdbcTemplate.query(
                "select user_no, id, pw, name, pn, pn2, email, email2, addr, addr2, addr3, reg_date from user where user_no = ?",
                new RowMapper<Register>() {
                    @Override
                    public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Register register = new Register();

                        register.setUserNo(rs.getInt("user_no"));
                        register.setId(rs.getString("id"));
                        register.setPw(rs.getString("pw"));
                        register.setName(rs.getString("name"));
                        register.setPn(rs.getString("pn"));
                        register.setPn2(rs.getString("pn2"));
                        register.setEmail(rs.getString("email"));
                        register.setEmail2(rs.getString("email2"));
                        register.setAddr(rs.getString("addr"));
                        register.setAddr2(rs.getString("addr2"));
                        register.setAddr3(rs.getString("addr3"));
                        register.setRegDate(rs.getDate("reg_date"));

                        return register;
                    }
                }, userNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer userNo) throws Exception {
        String query = "delete from user where user_no = ?";

        jdbcTemplate.update(query, userNo);
    }

    public void update(Register register) throws Exception {
        String query = "update user set pw = ?, pn = ?, pn2 = ?, email = ?, email2 = ? where user_no = ?";

        jdbcTemplate.update(query, register.getPw(), register.getPn(), register.getPn2(), register.getEmail(), register.getEmail2(), register.getUserNo());
    }
/*
    public Register idChk(Integer userNo) throws Exception {
        String query = "select count(*) from user where id = ?";
        return
}
 */
}
