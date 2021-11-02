package com.example.Mini.service.board;

import com.example.Mini.entity.board.Notice;

import java.util.List;

public interface NoticeBoardService {
    public void register(Notice board) throws Exception;

    public List<Notice> list() throws Exception;

    public Notice read(Integer boardNo) throws Exception;

    public void remove(Integer boardNo) throws Exception;

    public void modify(Notice board) throws Exception;
}