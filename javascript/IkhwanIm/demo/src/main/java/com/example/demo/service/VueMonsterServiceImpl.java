package com.example.demo.service;

import com.example.demo.entity.Monster;
import com.example.demo.repository.VueMonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시한다.
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
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