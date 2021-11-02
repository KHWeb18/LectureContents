package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface VueProductService {
    public void register(Product product);

    public List<Product> lists() throws Exception;

    public Product read(Integer productNo) throws Exception;

    public void remove(Integer productNo) throws Exception;

    public void modify(Product product) throws Exception;
}
