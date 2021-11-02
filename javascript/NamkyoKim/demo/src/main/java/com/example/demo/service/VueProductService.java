package com.example.demo.service;

import com.example.demo.eutity.Board;
import com.example.demo.eutity.Product;

import java.util.List;

public interface VueProductService {
    public void register(Product product) throws Exception;

    public List<Product> list() throws Exception;

    public Product read(Integer productNo) throws Exception;

    public void remove(Integer productNo) throws Exception;

    public void modify(Product product)throws Exception;

}