package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    public void productregister(Product product);

    public List<Product> productlist() throws Exception;

    public Product productread(Integer productNo) throws Exception;


}
