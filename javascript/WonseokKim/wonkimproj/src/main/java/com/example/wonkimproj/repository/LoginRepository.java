package com.example.wonkimproj.repository;

import com.example.wonkimproj.entity.Login;
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
public class LoginRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Login login) throws Exception {
        String query = "insert into login (id, pw) values (?, ?)";

        jdbcTemplate.update(query, login.getId(), login.getPw());
    }

    public void login(Login login) throws Exception {

        List<Login> results = jdbcTemplate.query(
                "select id, pw from login where id = ?",

                new RowMapper<Login>() {
                    @Override
                    public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Login login = new Login();

                        login.setId(rs.getString("id"));
                        login.setPw(rs.getString("pw"));

                        return login;
                    }
                }, login.getId());

        Login tmp = results.get(0);
        log.info("tmp: " + tmp);

        if (tmp.getPw().equals(login.getPw())) {
            log.info("pw Correct");
        } else {
            log.info("pw Incorrect");
        }
    }

    public List<Login> list() throws Exception {
        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<Login> results = jdbcTemplate.query(
                "select login_no, id, pw, reg_date from login " +
                        "where login_no > 0 order by login_no desc",
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Login>() {
                    @SneakyThrows
                    @Override
                    public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Login login = new Login();

                        login.setLoginNo(rs.getInt("login_no"));
                        login.setId(rs.getString("id"));
                        login.setPw(rs.getString("pw"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        login.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return login;
                    }
                }
        );

        return results;
    }
}