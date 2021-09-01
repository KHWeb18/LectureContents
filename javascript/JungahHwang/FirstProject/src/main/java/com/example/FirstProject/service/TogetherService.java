package com.example.FirstProject.service;

import com.example.FirstProject.entity.Together;

import java.util.List;

public interface TogetherService {
    public void register(Together together) throws Exception;
    public List<Object[]> lists() throws Exception;
    public List<Object[]> read(Long boardNo) throws Exception;
    public void modify(Together together) throws Exception;
    public void remove(Long boardNo) throws Exception;
}
