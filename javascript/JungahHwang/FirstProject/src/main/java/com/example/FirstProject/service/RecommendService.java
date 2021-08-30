package com.example.FirstProject.service;

import com.example.FirstProject.entity.Recommend;

import java.util.List;

public interface RecommendService {
    public void register(Recommend recommend) throws Exception;
    public List<Object[]> lists() throws Exception;
    public List<Object[]> read(Long boardNo) throws Exception;
    public void modify(Recommend recommend) throws Exception;
}
