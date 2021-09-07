package com.example.FirstProject.service;

import com.example.FirstProject.entity.Recommend;
import com.example.FirstProject.request.RecommendDto;

import java.util.List;

public interface RecommendService {
    public Recommend register(RecommendDto recommendDto) throws Exception;
    public List<Object[]> lists() throws Exception;
    public List<Object[]> read(Long boardNo) throws Exception;
    public Recommend findByBoardNo(Long boardNo) throws Exception;
    public void modify(Recommend recommend, RecommendDto recommendDto) throws Exception;
    public void remove(Recommend recommend) throws Exception;
}
