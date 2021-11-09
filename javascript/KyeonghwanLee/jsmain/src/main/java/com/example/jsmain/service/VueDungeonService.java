package com.example.jsmain.service;

import com.example.jsmain.entity.Dungeon;
import com.example.jsmain.entity.Monster;

import java.util.List;


public interface VueDungeonService {

    public List<Dungeon> randomList() throws Exception;
}