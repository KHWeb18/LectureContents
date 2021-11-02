package com.example.Quiz.repository;

import com.example.Quiz.entity.Dungeon;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Setter
@Repository
public class DungeonRepository {

    static final int DUNGEON_NUM = 3;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Dungeon> randomList() throws Exception {

        int[] randArr = new int[DUNGEON_NUM];

        List<Dungeon> tmp;

        int max = jdbcTemplate.queryForObject(
                "select count(1) from dungeon",
                Integer.class
        );

        for(int i = 0; i < DUNGEON_NUM; i++) {
            randArr[i] = (int) (Math.random() * max) + 1;
        }

        List<Dungeon> results = new ArrayList<Dungeon>();

        for (int i = 0; i < DUNGEON_NUM; i++) {
            tmp = jdbcTemplate.query(
                "select dungeon_no, name, description, monster_amount, reg_date " +
                        "from dungeon where dungeon_no = ?",

                new RowMapper<Dungeon>() {
                    @Override
                    public Dungeon mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Dungeon dungeon = new Dungeon();

                        dungeon.setDungeonNo(rs.getInt("dungeon_no"));
                        dungeon.setName(rs.getString("name"));
                        dungeon.setDescription(rs.getString("description"));
                        dungeon.setMonsterAmount(rs.getInt("monster_amount"));
                        dungeon.setRegDate(rs.getDate("reg_date"));

                        return dungeon;
                    }
                }, randArr[i]
            );

            results.add(tmp.get(0));
        }

        return results;
    }
}
