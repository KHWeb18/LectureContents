package com.example.miniProject.service.jpa;

import com.example.miniProject.entity.jpa.Board;

import java.util.List;

public interface JPABoardService {
    public void register(Board board) throws Exception;

    public List<Board> list() throws Exception;

    public Board read(Long boardNo) throws Exception;

    public void remove(Long boardNo) throws Exception;

    public void modify(Board board) throws Exception;

}