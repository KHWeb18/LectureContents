package com.example.demo.repository;

import com.example.demo.entity.Board;
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
        String query = "insert into vueproduct (product_name, description, producer, price) values (?, ?, ?, ?)";

        jdbcTemplate.update(query, product.getProduct_name(), product.getDescription(),
                product.getProducer(), product.getPrice());
    }

    public List<Product> list() throws Exception {

        List<Product> results = jdbcTemplate.query(
                "select product_no, product_name, description, producer, price, reg_date from vueproduct " +
                        "where product_no > 0 order by product_no desc",

                new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        product.setProductNo(rs.getInt("product_no"));
                        product.setProduct_name(rs.getString("product_name"));
                        product.setDescription(rs.getString("description"));
                        product.setProducer(rs.getString("producer"));
                        product.setPrice((rs.getInt("price")));

                        product.setRegDate(rs.getDate("reg_date"));

                        return product;
                    }
                }
        );

        return results;
    }

    public Product read (Integer productNo) throws Exception {
        List<Product> results = jdbcTemplate.query(
                "select product_no, product_name, description, producer, price, " +
                        "reg_date from vueproduct where product_no = ?",
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        product.setProductNo(rs.getInt("product_no"));
                        product.setProduct_name(rs.getString("product_name"));
                        product.setDescription(rs.getString("description"));
                        product.setProducer(rs.getString("producer"));
                        product.setPrice(rs.getInt("price"));
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
        String query = "update vueproduct set product_name = ?, description = ? where product_no = ?";
        jdbcTemplate.update(query, product.getProduct_name(), product.getDescription(), product.getProductNo());
    }

}