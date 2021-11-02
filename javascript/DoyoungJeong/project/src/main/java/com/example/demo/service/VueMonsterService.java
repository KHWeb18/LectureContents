package com.example.demo.service;

import com.example.demo.entity.VueMonster;

import java.util.List;

public interface VueMonsterService {
    public void upload(VueMonster monster) throws Exception;

    public List<VueMonster> list() throws Exception;

    public VueMonster read(Integer monsterNo) throws Exception;

    public void remove(Integer monsterNo) throws Exception;

    public void modify(VueMonster monster) throws Exception;
}
