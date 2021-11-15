package com.example.tsback.service;

import com.example.tsback.entity.Board;

import java.util.List;

public interface BoardService {
    List<Board> list() throws Exception;

    void register(Board board) throws Exception;

    Board read(long boardNo) throws Exception;

    void modify(Board board) throws Exception;

    void delete(long boardNo) throws Exception;
}
