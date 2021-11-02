package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.entity.NagetloningTest;

import java.util.List;

public interface VueMemberService {
    public void register(NagetloningTest nagetloningTest) throws Exception;

    public List<Board> list() throws Exception;

    public Board read(Integer boardNo) throws Exception;

    public void remove (Integer boardNo) throws  Exception;

    public  void modify(Board board) throws Exception;


}
