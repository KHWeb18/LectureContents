package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.VueBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service는 여기서 register가 여러방식으로동작할수 있음을 명시한다
//또한Controller가 Autowired에 자동으로 연결되도록 서포트 한다.

@Service
public class VueBoardServiceImpl implements VueBoardService {

    @Autowired
    private VueBoardRepository repository;

    @Override
    public void register(Board board) throws Exception{
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
