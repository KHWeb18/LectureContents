package com.example.jsmain.service;

import com.example.jsmain.entity.Monster;
import com.example.jsmain.entity.Product;
import com.example.jsmain.repository.VueMonsterRepository;
import com.example.jsmain.repository.VueProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueMonsterServiceImpl implements VueMonsterService {

    @Autowired
    private VueMonsterRepository repository;

    @Override
    public void register(Monster monster) throws Exception {
        repository.create(monster);
    }

    @Override
    public List<Monster> list() throws Exception {
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