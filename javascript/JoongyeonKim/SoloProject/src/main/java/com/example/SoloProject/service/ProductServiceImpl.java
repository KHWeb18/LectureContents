package com.example.SoloProject.service;

import com.example.SoloProject.entity.Board;
import com.example.SoloProject.entity.Product;
import com.example.SoloProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public void register(Product product) {
        repository.create(product);
    }

    @Override
    public List<Product> lists() throws Exception {
        return repository.lists();
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
