package com.example.miniProject.service.jpa;

import com.example.miniProject.entity.jpa.BoardDto;

import java.util.List;


public interface JPABoardService {
    public Long register(BoardDto boardDto) throws Exception;

    public List<BoardDto> list() throws Exception;

    public BoardDto read(Long boardNo) throws Exception;

    public void remove(Long boardNo) throws Exception;

//    public void modify(BoardDto boardDto) throws Exception;

//    public List<BoardDto> search(String keyword) throws Exception;



}