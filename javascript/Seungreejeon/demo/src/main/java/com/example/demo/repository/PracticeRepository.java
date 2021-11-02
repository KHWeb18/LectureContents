//package com.example.demo.repository;
//
//
//import com.example.demo.entity.Board;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//public class PracticeRepository {
//
//    JdbcTemplate jdbcTemplate;
//
//    public void register(Board board) {
//        String query = "insert into title, content, writer values( ?, ? , ?) " +
//                "from practiceboard";
//
//        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
//    }
//
//    public List<Board> list() {
//        String query = "select board_no, title, content, writer, regDate from practiceboard " +
//                "where board_no > 0 order by board_no desc";
//
//        List<Board> result = jdbcTemplate.query(query,
//                new RowMapper<Board>() {
//                    @Override
//                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        Board board = new Board();
//
//                        board.setBoardNo(rs.getInt("board_no"));
//                        board.setTitle(rs.getString("title"));
//                        board.setContent(rs.getString("content"));
//                        board.setWriter(rs.getString("writer"));
//                        board.setRegDate(rs.getDate("regDate"));
//
//                        return board;
//                    }
//                });
//        return result;
//    }
//
//    public Board read(Integer boardNo) {
//        String query = "select board_no, title, content, writer regDate " +
//                "from practiceboard where boardNo = ?";
//
//        List<Board> result = jdbcTemplate.query(query,
//                new RowMapper<Board>() {
//                    @Override
//                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        Board board = new Board();
//
//                        board.setBoardNo(rs.getInt("board_no"));
//                        board.setTitle(rs.getString("title"));
//                        board.setContent(rs.getString("content"));
//                        board.setWriter(rs.getString("writer"));
//                        board.setRegDate(rs.getDate("regDate"));
//
//                        return board;
//                    }
//                }, boardNo);
//        return result.isEmpty() ? null : result.get(0);
//    }
//
//    public void modify(Board board) {
//        String query = "update set title, content , write values(? , ? , ?) " +
//                "from practiceboard where board_no = ?";
//
//        jdbcTemplate.update(query, board.getTitle(), board.getTitle(), board.getContent(), board.getWriter(), board.getBoardNo());
//    }
//
//    public void delete(Integer boardNo) {
//        String query = "delete from practiceboard where board_no = ?";
//
//        jdbcTemplate.update(query, boardNo);
//    }
//}
