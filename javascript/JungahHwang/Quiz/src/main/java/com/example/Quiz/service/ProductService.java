package com.example.Quiz.service;

import com.example.Quiz.entity.Product;

import java.util.List;

public interface ProductService {
    public void register(Product product) throws Exception;

    public List<Product> list() throws Exception;

    public Product read(Integer productNo) throws Exception;

    public void modify(Product product) throws Exception;

    public void remove(Integer productNo) throws Exception;
}
