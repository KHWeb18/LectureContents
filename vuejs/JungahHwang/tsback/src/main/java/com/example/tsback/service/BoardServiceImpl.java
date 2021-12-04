package com.example.tsback.service;

import com.example.tsback.entity.Board;
import com.example.tsback.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository repository;

    @Override
    public List<Board> list() throws Exception {
        return repository.findAll();
    }

    @Override
    public void register(Board board) throws Exception {
        repository.save(board);
    }

    @Override
    public Board read(long boardNo) throws Exception {
        Optional<Board> maybeBoard = repository.findById(boardNo);
        return maybeBoard.get();
    }

    @Override
    public void modify(Board board) throws Exception {
        repository.save(board);
    }

    @Override
    public void delete(long boardNo) throws Exception {
        repository.deleteById(boardNo);
    }
}
