package com.example.FirstProject.service;

import com.example.FirstProject.entity.Together;
import com.example.FirstProject.request.TogetherDto;

import java.util.List;

public interface TogetherService {
    Together register(TogetherDto togetherDto) throws Exception;
    List<Object[]> lists() throws Exception;
    List<Object[]> read(Long boardNo) throws Exception;
    Together findByBoardNo(Long boardNo) throws Exception;
    void modify(Together together, TogetherDto togetherDto) throws Exception;
    void remove(Together together) throws Exception;
    List<Together> userRead(String id) throws Exception;
}
