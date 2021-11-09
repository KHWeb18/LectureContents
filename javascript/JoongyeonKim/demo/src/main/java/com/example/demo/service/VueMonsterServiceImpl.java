package com.example.demo.service;

import com.example.demo.entity.Monster;
import com.example.demo.entity.Product;
import com.example.demo.repository.VueMonsterRepository;
import com.example.demo.repository.VueProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueMonsterServiceImpl implements VueMonsterService {

    @Autowired
    private VueMonsterRepository repository;

    @Override
    public void register(Monster monster)   {
        repository.create(monster);
    }

    @Override
    public List<Monster> lists() throws Exception {
        return repository.list();
    }

    @Override
    public Monster read(Integer monsterNo) throws Exception {
        return repository.read(monsterNo);
    }

    @Override
    public void remove(Integer monsterNo) throws Exception {
        repository.delete(monsterNo);
    }

    @Override
    public void modify(Monster monster) throws Exception {
        repository.update(monster);
    }

}
