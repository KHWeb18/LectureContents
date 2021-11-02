package com.example.demo.service;

import com.example.demo.eutity.Product;
import com.example.demo.repository.VueProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시함
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
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