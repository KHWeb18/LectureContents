package com.example.project.repository;


import com.example.project.entity.Review;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReviewRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Review review) throws Exception {
        // insert into board: DB에 있는 board 테이블에 값을 집어넣겠다.
        // (title, content, writer): board 테이블 내에 있는 컬럼들임
        // values (?, ?, ?): 뭔가 값을 넣을것인데 아직 미정이란 뜻
        String query = "insert into review (content, writer) values (?, ?)";

        // jdbcTemplate.update(): 이것을 통해 실제 DB상의 값을 갱신함
        // query: 구동시킬 DB의 쿼리
        // 나머지 3개: query에 있는 ?에 배치할 값들을 결정함
        jdbcTemplate.update(query, review.getContent(), review.getWriter());
    }

    public List<Review> list() throws Exception {
        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<Review> results = jdbcTemplate.query(
                "select review_no, content, writer, reg_date, upd_date from review " +
                        "where review_no > 0 order by review_no desc",
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Review>() {
                    @SneakyThrows
                    @Override
                    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Review review = new Review();

                        // rs.getInt()는 DB에 있는 정수형 정보를 얻어옴
                        review.setReviewNo(rs.getInt("review_no"));
                        // rs.getString()은 DB에 있는 문자열 정보를 얻어옴
                        review.setContent(rs.getString("content"));
                        review.setWriter(rs.getString("writer"));

                        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        //board.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        review.setRegDate(rs.getDate("reg_date"));
                        review.setUpdDate(rs.getDate("upd_date"));
                        return review;
                    }
                }
        );

        return results;
    }

    public Review read (Integer reviewNo) throws Exception {
        List<Review> results = jdbcTemplate.query(
                "select review_no, content, writer, reg_date, upd_date from review where review_no = ?",
                new RowMapper<Review>() {
                    @Override
                    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Review review = new Review();

                        review.setReviewNo(rs.getInt("review_no"));
                        review.setContent(rs.getString("content"));
                        review.setWriter(rs.getString("writer"));
                        review.setRegDate(rs.getDate("reg_date"));
                        review.setUpdDate(rs.getDate("upd_date"));

                        return review;
                    }
                }, reviewNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer reviewNo) throws Exception {
        String query = "delete from review where review_no = ?";

        jdbcTemplate.update(query, reviewNo);
    }

    public void update(Review review) throws Exception {
        String query = "update review set content = ? where review_no = ?";

        jdbcTemplate.update(query, review.getContent(), review.getReviewNo());
    }
}