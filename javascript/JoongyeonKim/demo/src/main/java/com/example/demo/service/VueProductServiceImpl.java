package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.entity.Product;
import com.example.demo.repository.VueProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueProductServiceImpl implements VueProductService {

    @Autowired
    private VueProductRepository productrepository;

    @Override
    public void register(Product product)   {
        productrepository.create(product);
    }

    @Override
    public List<Product> lists() throws Exception {
        return productrepository.list();
    }

    @Override
    public Product read(Integer productNo) throws Exception {
        return productrepository.read(productNo);
    }

    @Override
    public void remove(Integer productNo) throws Exception {
        productrepository.delete(productNo);
    }

    @Override
    public void modify(Product product) throws Exception {
        productrepository.update(product);
    }
}
