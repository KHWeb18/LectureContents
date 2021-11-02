package com.example.cholongtest.repository;

import com.example.cholongtest.entity.Product;
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
        String query = "insert into vueproduct (title, price, content, writer) values (?, ?, ?, ?)";

        jdbcTemplate.update(query, product.getTitle(), product.getPrice(), product.getContent(), product.getWriter());
    }

    public List<Product> list() throws Exception {
        List<Product> results = jdbcTemplate.query(
                "select product_no, title, price, content, writer, reg_date from vueproduct " +
                        "where product_no > 0 order by product_no desc",
                new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        product.setProductNo(rs.getInt("product_no"));
                        product.setTitle(rs.getString("title"));
                        product.setPrice(rs.getString("price"));
                        product.setContent(rs.getString("content"));
                        product.setWriter(rs.getString("writer"));

                        product.setRegDate(rs.getDate("reg_date"));

                        return product;
                    }
                }
        );

        return results;
    }

    public Product read (Integer productNo) throws Exception {
        List<Product> results = jdbcTemplate.query(
                "select product_no, title, price, content, writer, reg_date from vueproduct where product_no = ?",
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        product.setProductNo(rs.getInt("product_no"));
                        product.setTitle(rs.getString("title"));
                        product.setPrice(rs.getString("price"));
                        product.setContent(rs.getString("content"));
                        product.setWriter(rs.getString("writer"));
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

        jdbcTemplate.update(query, product.getTitle(), product.getPrice(),  product.getContent(), product.getProductNo());
    }
}