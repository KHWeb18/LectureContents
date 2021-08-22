package com.example.miniProject.repository.jpa;

import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.entity.jpa.BoardDto;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.entity.jpa.TestMember;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public interface JPABoardRepository extends JpaRepository<Board, Long> {

//    List<Board> findByKeyword(String keyword);

//    @Modifying
//    @Query("update board b from board set b.title where b.boardNo = ? ")
//    void update(@Param(value = "title") String title, @Param(value = "boardNo") Long boardNo);

//    @Query("select b from Board b order by b.boardNo desc")
//    Stream<Board> findAllDesc();
//
//    @Query(value = "select b.boardNo = :#{#board.boardNo}, b.title = :#{#board.title}," +
//            "b.content = :#{#board.content}, b.writer = :#{#board.writer}, " +
//            "b.regDate = = :#{#board.regDate} form Board where b.boardNo = :#{#board.boardNo} ", nativeQuery = false)
//    Board read(@Param("board") Board board);

//    @Modifying
//    @Query(value="update Board b set b.title = :#{#board.title}," +
//            " b.content = :#{#board.content} " +
//            "where b.boardNo = :#{#board.boardNo}", nativeQuery = false)
////    void update(@Param("title") String title, @Param("content") String content, @Param("boardNo")Long boardNo);
//    void update(@Param("board") BoardDto boardDto);
}

//@Repository
//public class JPABoardRepository  {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public void create(Board board) throws Exception {
//        String query = "insert into board (title, content, writer) values (?, ?, ?)";
//        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
//    }
//
//    public List<Board> list() throws Exception {
//        List<Board> results = jdbcTemplate.query(
//                "select board_no, title, content, writer, reg_date from board " +
//                        "where board_no > 0 order by board_no desc",
//                new RowMapper<Board>() {
//                    @SneakyThrows
//                    @Override
//                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        Board board = new Board();
//
//                        board.setBoardNo(rs.getInt("board_no"));
//                        board.setTitle(rs.getString("title"));
//                        board.setContent(rs.getString("content"));
//                        board.setWriter(rs.getString("writer"));
//                        board.setRegDate(rs.getDate("reg_date"));
//
//                        return board;
//                    }
//                }
//        );
//
//        return results;
//    }
//
//    public Board read (Integer boardNo) throws Exception {
//        List<Board> results = jdbcTemplate.query(
//                "select board_no, title, content, writer, reg_date from board where board_no = ?",
//                new RowMapper<Board>() {
//                    @Override
//                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        Board board = new Board();
//
//                        board.setBoardNo(rs.getInt("board_no"));
//                        board.setTitle(rs.getString("title"));
//                        board.setContent(rs.getString("content"));
//                        board.setWriter(rs.getString("writer"));
//                        board.setRegDate(rs.getDate("reg_date"));
//
//                        return board;
//                    }
//                }, boardNo);
//
//        return results.isEmpty() ? null : results.get(0);
//    }
//
//    public void delete(Integer boardNo) throws Exception {
//        String query = "delete from board where board_no = ?";
//
//        jdbcTemplate.update(query, boardNo);
//    }
//
//    public void update(Board board) throws Exception {
//        String query = "update board set title = ?, content = ? where board_no = ?";
//
//        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());
//    }
//
//    public void search(Board board) throws Exception {
//        String query = "select * from board where title like '%?%' or content like '%?%'";
//        jdbcTemplate.update(query, board.getTitle(), board.getContent());
//    }
//
//}
