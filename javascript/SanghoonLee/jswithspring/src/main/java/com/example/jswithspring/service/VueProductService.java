package com.example.jswithspring.service;

import com.example.jswithspring.entity.Board;
import com.example.jswithspring.entity.Product;

import java.util.List;

public interface VueProductService {
    public void register(Product product) throws Exception;

    public List<Product> list() throws Exception;

    public Product read(Integer productNo) throws Exception;

    public void remove(Integer productNo) throws Exception;

    public void modify(Product product) throws Exception;
}
