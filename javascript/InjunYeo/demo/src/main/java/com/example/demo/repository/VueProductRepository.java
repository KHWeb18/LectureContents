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
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class VueProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Product product) throws Exception{
        String query = "insert into vueproduct (name, price, description, producer) values (?,?,?,?)";

        jdbcTemplate.update(query,product.getName(),product.getPrice(),product.getDescription(),product.getProducer());
    }

    public List<Product> list() throws Exception{
        //RowMapper를 통해 얻은  행을 하나씩 List에 집어 넣는다.
        //results엔 DB에서 얻어온 행 정보들이 있다.
        List<Product> results = jdbcTemplate.query(
                "select product_no,name,price,description,producer,reg_date from vueproduct " +
                        "where product_no > 0 order by product_no desc",
                //Row:행
                //여러개의 Column(열)들이 행 1개에 포함되어있음
                //여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        //rs.getInt()는 DB에 있는 정수형 정보를 얻어옴
                        product.setProductNo(rs.getInt("product_no"));
                        //rs.getString()은 DB에 있는 문자열 정보를 얻어옴
                        product.setName(rs.getString("name"));
                        product.setPrice(rs.getString("price"));
                        product.setDescription(rs.getString("description"));
                        product.setProducer(rs.getString("producer"));
                        //rs.getDate()는 DB에 있는 날자 정보를 얻어옴
                        //board.setRegDate(rs.getTimestamp("reg_date"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        product.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));



                        //리턴된 정보가 results로 들어가는것임
                        return product;
                    }
                }
        );



        return results;
    }

    public Product read(Integer productNo) throws Exception{
        //여기서 매개변수가 들어가는 시점이 언제일까?

        List<Product> results = jdbcTemplate.query(
                "select product_no, name, price, description,producer, reg_date from vueproduct where product_no =? ",
                new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        product.setProductNo(rs.getInt("product_no"));
                        product.setName(rs.getString("name"));
                        product.setPrice(rs.getString("price"));
                        product.setDescription(rs.getString("description"));
                        product.setProducer(rs.getString("producer"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        product.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return product;
                    }
                },productNo);
        //굳이 리스트를써서 results.get(0)인 이유는 query의 반환값이 리스트이기때문에 형변환을 따로 하지않으려고 쓴것이다.
        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer productNo) throws Exception{

        String query = "delete from vueproduct where product_no =?";

        jdbcTemplate.update(query,productNo);

    }

    public void update(Product product) throws Exception{
        String query = "update vueproduct set name=?, price=?, description=? where product_no = ? ";

        jdbcTemplate.update(query,product.getName(),product.getPrice(),product.getDescription(),product.getProductNo());
    }


}
