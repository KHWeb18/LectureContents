package com.example.Quiz.repository;

import com.example.Quiz.entity.Monster;
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
public class MonsterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create (Monster monster) throws Exception {
        String query = "insert into monster (name, hp, exp, money, item) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, monster.getName(), monster.getHp(), monster.getExp(), monster.getMoney(), monster.getItem());
    }

    public List<Monster> list() throws Exception {
        List<Monster> results = jdbcTemplate.query(
                "select monster_no, name, hp, exp, money, item, reg_date from monster " +
                        "where monster_no > 0 order by monster_no desc",
                new RowMapper<Monster>() {
                    @Override
                    public Monster mapRow(ResultSet rs, int i) throws SQLException {
                        Monster monster = new Monster();

                        monster.setMonsterNo(rs.getInt("monster_no"));
                        monster.setName(rs.getString("name"));
                        monster.setHp(rs.getInt("hp"));
                        monster.setExp(rs.getInt("exp"));
                        monster.setMoney(rs.getInt("money"));
                        monster.setItem(rs.getString("item"));
                        monster.setRegDate(rs.getDate("reg_date"));

                        return monster;
                    }
                }
        );
        return results;
    }

    public Monster read(Integer monsterNo) throws Exception {
        List<Monster> results = jdbcTemplate.query(
                "select monster_no, name, hp, exp, money, item, reg_date from monster where monster_no = ?",
                new RowMapper<Monster>() {
                    @Override
                    public Monster mapRow(ResultSet rs, int i) throws SQLException {
                        Monster monster = new Monster();

                        monster.setMonsterNo(rs.getInt("monster_no"));
                        monster.setName(rs.getString("name"));
                        monster.setHp(rs.getInt("hp"));
                        monster.setExp(rs.getInt("exp"));
                        monster.setMoney(rs.getInt("money"));
                        monster.setItem(rs.getString("item"));
                        monster.setRegDate(rs.getDate("reg_date"));

                        return monster;
                    }
                }, monsterNo
        );
        return results.isEmpty() ? null : results.get(0);
    }

    public void update(Monster monster) throws Exception {
        String query = "update monster set name = ?, hp = ?, exp = ?, money = ?, item = ? where monster_no = ?";

        jdbcTemplate.update(query, monster.getName(), monster.getHp(), monster.getExp(), monster.getMoney(),
                monster.getItem(), monster.getMonsterNo());
    }

    public void delete(Integer monsterNo) throws Exception {
        String query = "delete from monster where monster_no = ?";

        jdbcTemplate.update(query, monsterNo);
    }
}
