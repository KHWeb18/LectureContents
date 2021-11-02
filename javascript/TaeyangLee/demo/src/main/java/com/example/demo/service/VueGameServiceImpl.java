package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.Monster;
import com.example.demo.entity.Product;
import com.example.demo.repository.VueGameRepository;
import com.example.demo.repository.VueMemberRepository;
import com.example.demo.repository.VueProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueGameServiceImpl implements VueGameService{
    @Autowired
    private VueGameRepository repository;

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
