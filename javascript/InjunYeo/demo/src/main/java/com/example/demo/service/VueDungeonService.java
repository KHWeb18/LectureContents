package com.example.demo.service;

import com.example.demo.entity.Dungeon;
import com.example.demo.entity.Monster;

import java.util.List;

public interface VueDungeonService {

    public List<Dungeon> randomList() throws Exception;

}