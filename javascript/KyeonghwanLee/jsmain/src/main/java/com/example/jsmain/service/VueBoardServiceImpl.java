package com.example.jsmain.service;

import com.example.jsmain.entity.Board;
import com.example.jsmain.repository.VueBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시한다.
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
@Service
public class VueBoardServiceImpl implements VueBoardService {

    @Autowired
    private VueBoardRepository repository;

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