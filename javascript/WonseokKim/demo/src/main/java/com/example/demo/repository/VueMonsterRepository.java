package com.example.demo.repository;

import com.example.demo.entity.Monster;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VueMonsterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Monster monster) throws Exception {
        // insert into board: DB에 있는 board 테이블에 값을 집어넣겠다.
        // (title, content, writer): board 테이블 내에 있는 컬럼들임
        // values (?, ?, ?): 뭔가 값을 넣을것인데 아직 미정이란 뜻
        String query = "insert into vuemonster (monster_name, monster_hp, monster_exp, " +
                "monster_money, monster_description) values (?, ?, ?, ?, ?)";

        // jdbcTemplate.update(): 이것을 통해 실제 DB상의 값을 갱신함
        // query: 구동시킬 DB의 쿼리
        // 나머지 3개: query에 있는 ?에 배치할 값들을 결정함
        jdbcTemplate.update(query, monster.getMonster_name(), monster.getMonster_hp(), monster.getMonster_exp(),
                monster.getMonster_money(), monster.getMonster_description());
    }

    public List<Monster> list() throws Exception {
        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<Monster> results = jdbcTemplate.query(
                "select monster_no, monster_name, monster_hp, monster_exp, monster_money," +
                        "monster_description, reg_date from vuemonster " +
                        "where monster_no > 0 order by monster_no desc",
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Monster>() {
                    @SneakyThrows
                    @Override
                    public Monster mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Monster monster = new Monster();

                        monster.setMonsterNo(rs.getInt("monster_no"));
                        monster.setMonster_name(rs.getString("monster_name"));
                        monster.setMonster_description(rs.getString("monster_description"));
                        monster.setMonster_hp(rs.getInt("monster_hp"));
                        monster.setMonster_exp(rs.getInt("monster_exp"));
                        monster.setMonster_money(rs.getInt("monster_money"));

                        monster.setRegDate(rs.getDate("reg_date"));

                        return monster;
                    }
                }
        );

        return results;
    }

    public Monster read (Integer monsterNo) throws Exception {
        List<Monster> results = jdbcTemplate.query(
                "select monster_no, monster_name, monster_description, monster_hp," +
                        "monster_exp, monster_money, reg_date from vuemonster where monster_no = ?",
                new RowMapper<Monster>() {
                    @Override
                    public Monster mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Monster monster = new Monster();

                        monster.setMonsterNo(rs.getInt("monster_no"));
                        monster.setMonster_name(rs.getString("monster_name"));
                        monster.setMonster_description(rs.getString("monster_description"));
                        monster.setMonster_hp(rs.getInt("monster_hp"));
                        monster.setMonster_exp(rs.getInt("monster_exp"));
                        monster.setMonster_money(rs.getInt("monster_money"));

                        monster.setRegDate(rs.getDate("reg_date"));

                        return monster;
                    }
                }, monsterNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer monsterNo) throws Exception {
        String query = "delete from vuemonster where monster_no = ?";

        jdbcTemplate.update(query, monsterNo);
    }

    public void update(Monster monster) throws Exception {
        String query = "update vuemonster set monster_name = ?, monster_hp = ?," +
                "monster_exp = ?, monster_money = ?, monster_description = ? where monster_no = ?";

        jdbcTemplate.update(query, monster.getMonster_name(), monster.getMonster_hp(),
                monster.getMonster_exp(), monster.getMonster_money(), monster.getMonster_description(), monster.getMonsterNo());
    }
}