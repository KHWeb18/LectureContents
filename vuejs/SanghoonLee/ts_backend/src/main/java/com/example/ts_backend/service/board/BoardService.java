package com.example.ts_backend.service.board;

import com.example.ts_backend.entity.board.Board;

import java.util.List;

public interface BoardService {
    public List<Board> list() throws Exception;

    public void register(Board board) throws Exception;

    public Board read(long boardNo) throws Exception;

    public void modify(Board board) throws Exception;

    public void delete(long boardNo) throws Exception;
}
