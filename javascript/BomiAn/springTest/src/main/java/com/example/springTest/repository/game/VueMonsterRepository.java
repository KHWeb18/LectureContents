package com.example.springTest.repository.game;

import com.example.springTest.entity.Product;
import com.example.springTest.entity.game.Monster;
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
        String query = "insert into monster (monster_name, monster_hp, monster_exp, monster_money) values (?, ?, ?, ?)";

        jdbcTemplate.update(query, monster.getMonsterName(), monster.getMonsterHp(),
                monster.getMonsterExp(), monster.getMonsterMoney());
    }

    public List<Monster> list() throws Exception {

        List<Monster> results = jdbcTemplate.query("select monster_no, monster_name, monster_hp, monster_exp, monster_money, reg_date from monster" +
                        " where monster_no > 0 order by monster_no desc",

                new RowMapper<Monster>() {
                    @SneakyThrows
                    @Override
                    public Monster mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Monster monster = new Monster();

                        monster.setMonsterNo(rs.getInt("monster_no"));
                        monster.setMonsterName(rs.getString("monster_name"));
                        monster.setMonsterHp(rs.getInt("monster_hp"));
                        monster.setMonsterExp(rs.getInt("monster_exp"));
                        monster.setMonsterMoney(rs.getInt("monster_money"));
                        monster.setRegDate(rs.getDate("reg_date"));

                        return monster;
                    }
                }
        );

        return results;
    }

    public Monster read (Integer monsterNo) throws Exception {
        List<Monster> results = jdbcTemplate.query(
                "select monster_no, monster_name, monster_hp, monster_exp, monster_money, reg_date from monster where monster_no = ?",
                new RowMapper<Monster>() {
                    @Override
                    public Monster mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Monster monster = new Monster();

                        monster.setMonsterNo(rs.getInt("monster_no"));
                        monster.setMonsterName(rs.getString("monster_name"));
                        monster.setMonsterHp(rs.getInt("monster_hp"));
                        monster.setMonsterExp(rs.getInt("monster_exp"));
                        monster.setMonsterMoney(rs.getInt("monster_money"));
                        monster.setRegDate(rs.getDate("reg_date"));

                        return monster;
                    }
                }, monsterNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer monsterNo) throws Exception {
        String query = "delete from monster where monster_no = ?";
        jdbcTemplate.update(query, monsterNo);
    }
    public void update(Monster monster) throws Exception {
        String query = "update monster set monster_name = ?, monster_hp = ?, monster_exp = ? , monster_money = ? where monster_no = ?";
        jdbcTemplate.update(query,monster.getMonsterName(), monster.getMonsterHp(), monster.getMonsterExp(), monster.getMonsterMoney(), monster.getMonsterNo());
    }
}
