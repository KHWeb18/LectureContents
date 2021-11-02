package com.example.demo.service;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository repository;
    @Override
    public void register(Board board) throws Exception {
        repository.create(board);
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