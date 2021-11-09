package com.example.demo.repository;

import com.example.demo.entity.Board;
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
public class VueBoardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Board board) throws Exception{
        String query = "insert into vueboard (title, content, writer) values (?,?,?)";

        jdbcTemplate.update(query,board.getTitle(),board.getContent(),board.getWriter());
    }

    public List<Board> list() throws Exception{
        //RowMapper를 통해 얻은  행을 하나씩 List에 집어 넣는다.
        //results엔 DB에서 얻어온 행 정보들이 있다.
        List<Board> results = jdbcTemplate.query(
                "select board_no,title,content,writer,reg_date from vueboard " +
                        "where board_no > 0 order by board_no desc",
                //Row:행
                //여러개의 Column(열)들이 행 1개에 포함되어있음
                //여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Board>() {
                    @SneakyThrows
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();

                        //rs.getInt()는 DB에 있는 정수형 정보를 얻어옴
                        board.setBoardNo(rs.getInt("board_no"));
                        //rs.getString()은 DB에 있는 문자열 정보를 얻어옴
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        //rs.getDate()는 DB에 있는 날자 정보를 얻어옴
                        //board.setRegDate(rs.getTimestamp("reg_date"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        board.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));



                        //리턴된 정보가 results로 들어가는것임
                        return board;
                    }
                }
        );



        return results;
    }

    public Board read(Integer boardNo) throws Exception{
        //여기서 매개변수가 들어가는 시점이 언제일까?

        List<Board> results = jdbcTemplate.query(
                "select board_no, title, content, writer, reg_date from vueboard where board_no =? ",
                new RowMapper<Board>() {
                    @SneakyThrows
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();

                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        board.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return board;
                    }
                },boardNo);
        //굳이 리스트를써서 results.get(0)인 이유는 query의 반환값이 리스트이기때문에 형변환을 따로 하지않으려고 쓴것이다.
        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer boardNo) throws Exception{

        String query = "delete from vueboard where board_no =?";

        jdbcTemplate.update(query,boardNo);

    }

    public void update(Board board) throws Exception{
        String query = "update vueboard set title=?, content=? where board_no = ? ";

        jdbcTemplate.update(query,board.getTitle(),board.getContent(),board.getBoardNo());
    }


}
