package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.entity.Product;
import com.example.demo.repository.VueBoardRepository;
import com.example.demo.repository.VueProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueProductServiceImpl implements VueProductService {

    @Autowired
    private VueProductRepository repository;

    @Override
    public void register(Product product) throws Exception {
        repository.create(product);
    }

    @Override
    public List<Product> list() throws Exception {
        return repository.list();
    }

    @Override
    public Product read(Integer productNo) throws Exception {
        return repository.read(productNo);
    }

    @Override
    public void remove(Integer productNo) throws Exception {
         repository.delete(productNo);
    }

    @Override
    public void modify(Product product) throws Exception {
         repository.update(product);
    }
}