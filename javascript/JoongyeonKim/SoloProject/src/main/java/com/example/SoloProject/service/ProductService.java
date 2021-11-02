package com.example.SoloProject.service;

import com.example.SoloProject.entity.Product;

import java.util.List;

public interface ProductService {
    public void register(Product product);

    public List<Product> lists() throws Exception;

    public Product read(Integer productNo) throws Exception;

    public void remove(Integer productNo) throws Exception;

    public void modify(Product product) throws Exception;
}
