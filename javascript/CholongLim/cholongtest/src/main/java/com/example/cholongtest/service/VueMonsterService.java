// service 어떤 서비스인지

package com.example.cholongtest.service;

import com.example.cholongtest.entity.Monster;

import java.util.List;

public interface VueMonsterService {
    public void register(Monster monster) throws Exception;

    public List<Monster> list() throws Exception;

    public Monster read(Integer monsterNo) throws Exception;

    public void remove(Integer monsterNo) throws Exception;

    public void modify(Monster monster) throws Exception;

}
