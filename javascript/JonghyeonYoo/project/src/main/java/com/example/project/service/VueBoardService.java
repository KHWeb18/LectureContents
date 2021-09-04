package com.example.project.service;


import com.example.project.entity.Board;

import java.util.List;

public interface VueBoardService {
     void register(Board board) throws Exception;

     List<Board> list() throws Exception;

     Board read(Integer boardNo) throws Exception;

     void remove(Integer boardNo) throws Exception;

     void modify(Board board) throws Exception;
}