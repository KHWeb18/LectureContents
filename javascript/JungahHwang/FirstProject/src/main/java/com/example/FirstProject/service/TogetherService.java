package com.example.FirstProject.service;

import com.example.FirstProject.entity.Together;
import com.example.FirstProject.request.TogetherDto;

import java.util.List;

public interface TogetherService {
    public Together register(TogetherDto togetherDto) throws Exception;
    public List<Object[]> lists() throws Exception;
    public List<Object[]> read(Long boardNo) throws Exception;
    public Together findByBoardNo(Long boardNo) throws Exception;
    public void modify(Together together, TogetherDto togetherDto) throws Exception;
    public void remove(Together together) throws Exception;
}
