package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productrepository;

    @Override
    public void productregister(Product product) {
        productrepository.create(product);
    }

    @Override
    public List<Product> productlist() throws Exception {
        return productrepository.productlist();
    }

    @Override
    public Product productread(Integer productNo) throws Exception {
        return productrepository.productread(productNo);
    }
}
