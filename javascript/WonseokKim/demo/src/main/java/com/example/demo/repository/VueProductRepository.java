package com.example.demo.repository;

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
public class VueProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Product product) throws Exception {
        // insert into board: DB에 있는 board 테이블에 값을 집어넣겠다.
        // (title, content, writer): board 테이블 내에 있는 컬럼들임
        // values (?, ?, ?): 뭔가 값을 넣을것인데 아직 미정이란 뜻
        String query = "insert into vueproduct (title, content, writer, price) values (?, ?, ?, ?)";

        // jdbcTemplate.update(): 이것을 통해 실제 DB상의 값을 갱신함
        // query: 구동시킬 DB의 쿼리
        // 나머지 3개: query에 있는 ?에 배치할 값들을 결정함
        jdbcTemplate.update(query, product.getTitle(), product.getContent(), product.getWriter(),
                product.getPrice());
    }

    public List<Product> list() throws Exception {
        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<Product> results = jdbcTemplate.query(
                "select product_no, title, content, writer, reg_date, price from vueproduct " +
                        "where product_no > 0 order by product_no desc",
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        // rs.getInt()는 DB에 있는 정수형 정보를 얻어옴
                        product.setProductNo(rs.getInt("product_no"));
                        // rs.getString()은 DB에 있는 문자열 정보를 얻어옴
                        product.setTitle(rs.getString("title"));
                        product.setContent(rs.getString("content"));
                        product.setWriter(rs.getString("writer"));
                        product.setPrice(rs.getString("price"));

                        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        //board.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        product.setRegDate(rs.getDate("reg_date"));

                        return product;
                    }
                }
        );

        return results;
    }

    public Product read (Integer productNo) throws Exception {
        List<Product> results = jdbcTemplate.query(
                "select product_no, title, content, writer, price, " +
                        "reg_date from vueproduct where product_no = ?",
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        product.setProductNo(rs.getInt("product_no"));
                        product.setTitle(rs.getString("title"));
                        product.setContent(rs.getString("content"));
                        product.setWriter(rs.getString("writer"));
                        product.setPrice(rs.getString("price"));
                        product.setRegDate(rs.getDate("reg_date"));

                        return product;
                    }
                }, productNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer productNo) throws Exception {
        String query = "delete from vueproduct where product_no = ?";

        jdbcTemplate.update(query, productNo);
    }

    public void update(Product product) throws Exception {
        String query = "update vueproduct set title = ?, price = ?, content = ? where product_no = ?";

        jdbcTemplate.update(query, product.getTitle(), product.getContent(),
                                product.getPrice(), product.getProductNo());
    }
}