package com.example.demo.service;

import com.example.demo.entity.Monster;
import com.example.demo.entity.Product;

import java.util.List;

public interface VueMonsterService {
    public void register(Monster monster) throws Exception;

    public List<Monster> list() throws Exception;

    public Monster read(Integer monsterNo) throws Exception;

    public void remove(Integer monsterNo) throws Exception;

    public void modify(Monster monster) throws Exception;
}