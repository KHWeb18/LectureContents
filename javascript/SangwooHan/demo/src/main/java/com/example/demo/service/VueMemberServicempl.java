package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.entity.NagetloningTest;
import com.example.demo.repository.VueBoardRepository;
import com.example.demo.repository.VueMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueMemberServicempl implements  VueMemberService{

    @Autowired
    private VueMemberRepository repository;

    @Override
    public void register(NagetloningTest nagetloningTest) throws Exception{
        repository.create(nagetloningTest);
    }

    @Override
    public List<Board> list() throws Exception {
        return repository.list();
    }

    @Override
    public Board read(Integer boardNo) throws Exception {
        return repository.read(boardNo);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        repository.delete(boardNo);
    }

    @Override
    public void modify(Board board) throws Exception {
        repository.update(board);
    }
}
