package com.example.demo.repository;

import com.example.demo.entity.Monster;
import com.example.demo.entity.Product;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VueGameRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Monster monster) throws Exception {
        String query = "insert into monster (name, monster_hp) values (?, ?)";

        jdbcTemplate.update(query, monster.getMonster_name(), monster.getMonster_hp());
    }

    public List<Monster> list() throws Exception {

        List<Monster> results = jdbcTemplate.query(
                "select monsterNo, monster_name, monster_hp from monster " +
                        "where monsterNo > 0 order by monsterNo desc",

                new RowMapper<Monster>() {
                    @SneakyThrows
                    @Override
                    public Monster mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Monster monster = new Monster();

                        monster.setMonsterNo(rs.getInt("monsterNo"));
                        monster.setMonster_name(rs.getString("monster_name"));
                        monster.setMonster_hp(rs.getInt("monster_hp"));



                        return monster;
                    }
                }
        );

        return results;
    }

    public Monster read (Integer monsterNo) throws Exception {
        List<Monster> results = jdbcTemplate.query(
                "select monsterNo, monster_name, monster_hp " +
                        "from monster where monsterNo = ?",
                new RowMapper<Monster>() {
                    @Override
                    public Monster mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Monster monster = new Monster();

                        monster.setMonsterNo(rs.getInt("monsterNo"));
                        monster.setMonster_name(rs.getString("monster_name"));
                        monster.setMonster_hp(rs.getInt("monster_hp"));

                        return  monster;
                    }
                }, monsterNo);

        return results.isEmpty() ? null : results.get(0);
    }


    public void delete(Integer monsterNo) throws Exception {
        String query = "delete from monster where monsterNo = ?";
        jdbcTemplate.update(query, monsterNo);
    }
    public void update(Monster monster) throws Exception {
        String query = "update monster set monster_name = ?, monster_hp = ? where monsterNo = ?";

        jdbcTemplate.update(query,monster.getMonster_name(),monster.getMonster_hp(),monster.getMonsterNo());
    }

}