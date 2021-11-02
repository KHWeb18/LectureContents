package com.example.demo.service;

import com.example.demo.entity.VueMonster;
import com.example.demo.repository.VueMonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueMonsterServiceImpl implements VueMonsterService{

    @Autowired
    private VueMonsterRepository repository;

    @Override
    public void upload(VueMonster monster) throws Exception {
        repository.upload(monster);
    }

    @Override
    public List<VueMonster> list() throws Exception {
        return repository.list();
    }

    @Override
    public VueMonster read(Integer monsterNo) throws Exception {
        return repository.read(monsterNo);
    }

    @Override
    public void remove(Integer monsterNo) throws Exception {
        repository.delete(monsterNo);
    }

    @Override
    public void modify(VueMonster monster) throws Exception {
        repository.update(monster);
    }
}
