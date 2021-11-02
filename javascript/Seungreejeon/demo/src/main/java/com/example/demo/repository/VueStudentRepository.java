
package com.example.demo.repository;

import com.example.demo.entity.Student;
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
public class VueStudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Student student) throws Exception {
        //학점 처리 int형으로 받아서 소수점오류발생
        switch (student.getScore()) {
            case 1:
                student.setGrade("f");
                break;
            case 2:
                student.setGrade("d");
                break;
            case 3:
                student.setGrade("b");
                break;
            case 4:
                student.setGrade("a");
                break;
            default:
                return;
        }

        String query = "insert into vuestudents (name, major, score, grade) values (?, ?, ?, ?)";

        jdbcTemplate.update(query, student.getName(), student.getMajor(), student.getScore(), student.getGrade());
    }

    public List<Student> list() throws Exception {

        List<Student> results = jdbcTemplate.query(
                "select student_no, name, major, score, grade, reg_date " +
                        "from vuestudents where student_no > 0 order by student_no desc",

                new RowMapper<Student>() {
                    @SneakyThrows
                    @Override
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Student student = new Student();

                        student.setStudentNo(rs.getInt("student_no"));
                        student.setMajor(rs.getString("major"));
                        student.setName(rs.getString("name"));
                        student.setScore(rs.getInt("score"));
                        student.setGrade(rs.getString("grade"));

                        student.setReg_Date(rs.getDate("reg_date"));

                        return student;
                    }
                }
        );

        return results;
    }
//
//    public Monster read (Integer monsterNo) throws Exception {
//        List<Monster> results = jdbcTemplate.query(
//                "select monster_no, name, description, hp, exp, dropMoney, dropItem, " +
//                        "reg_date from vuemonster where monster_no = ?",
//                new RowMapper<Monster>() {
//                    @Override
//                    public Monster mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        Monster monster = new Monster();
//
//                        monster.setMonsterNo(rs.getInt("monster_no"));
//                        monster.setName(rs.getString("name"));
//                        monster.setDescription(rs.getString("description"));
//                        monster.setHp(rs.getInt("hp"));
//                        monster.setExp((rs.getInt("exp")));
//                        monster.setDropMoney((rs.getInt("dropMoney")));
//                        monster.setDropItem(rs.getString("dropItem"));
//
//                        monster.setRegDate(rs.getDate("reg_date"));
//
//                        return monster;
//                    }
//                }, monsterNo);
//
//        return results.isEmpty() ? null : results.get(0);
//    }
//
//    public void delete(Integer monsterNo) throws Exception {
//        String query = "delete from vuemonster where monster_no = ?";
//
//        jdbcTemplate.update(query, monsterNo);
//    }
//
//    public void update(Monster monster) throws Exception {
//        String query = "update vuemonster set name = ?, description = ?, " +
//                "hp = ?, exp = ?, dropMoney = ?, dropItem = ? where monster_no = ?";
//
//        log.info("Vuemonster Repository: " + monster);
//
//        jdbcTemplate.update(query, monster.getName(), monster.getDescription(),
//                monster.getHp(), monster.getExp(), monster.getDropMoney(),
//                monster.getDropItem(), monster.getMonsterNo());
//    }

}