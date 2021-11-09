package com.example.demo.repository;

import com.example.demo.entity.VueMonster;
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
public class VueMonsterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void upload(VueMonster monster) throws Exception {
        String query = "insert into vueMonster (name, level, strength, hp, attribute, exp) values (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, monster.getName(), monster.getLevel(), monster.getStrength(), monster.getHp(),
                monster.getAttribute(), monster.getExp());
    }


    public List<VueMonster> list() throws Exception {
        List<VueMonster> results = jdbcTemplate.query(
                "select monster_no, name, level, strength, hp, attribute, exp from vuemonster " +
                        "where monster_no > 0 order by monster_no asc",
                new RowMapper<VueMonster>() {
                    @SneakyThrows
                    @Override
                    public VueMonster mapRow(ResultSet rs, int rowNum) throws SQLException {
                        VueMonster monster = new VueMonster();

                        monster.setMonsterNo(rs.getInt("monster_no"));
                        monster.setName(rs.getString("name"));
                        monster.setLevel(rs.getInt("level"));
                        monster.setStrength(rs.getInt("strength"));
                        monster.setHp(rs.getInt("hp"));
                        monster.setAttribute(rs.getString("attribute"));
                        monster.setExp(rs.getInt("exp"));

//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        monster.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));
                        return monster;
                    }
                }
        );
        return results;
    }

    public VueMonster read (Integer monsterNo) throws Exception {
        List<VueMonster> results = jdbcTemplate.query(
                "select monster_no, name, level, strength, hp, attribute, exp from vuemonster " +
                        "where monster_no = ?",
                new RowMapper<VueMonster>() {
                    @Override
                    public VueMonster mapRow(ResultSet rs, int rowNum) throws SQLException {
                        VueMonster monster = new VueMonster();

                        monster.setMonsterNo(rs.getInt("monster_no"));
                        monster.setName(rs.getString("name"));
                        monster.setLevel(rs.getInt("level"));
                        monster.setStrength(rs.getInt("strength"));
                        monster.setHp(rs.getInt("hp"));
                        monster.setAttribute(rs.getString("attribute"));
                        monster.setExp(rs.getInt("exp"));

                        return monster;
                    }
                }, monsterNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer monsterNo) throws Exception {
        String query = "delete from vuemonster where monster_no = ?";

        jdbcTemplate.update(query, monsterNo);
    }

    public void update(VueMonster monster) throws Exception {
        String query = "update vuemonster set name = ?, level = ?, strength = ?, hp = ?, attribute = ?, exp = ? where monster_no = ?";

        jdbcTemplate.update(query, monster.getName(), monster.getLevel(), monster.getStrength(), monster.getHp(), monster.getAttribute(), monster.getExp(), monster.getMonsterNo());
    }
}
