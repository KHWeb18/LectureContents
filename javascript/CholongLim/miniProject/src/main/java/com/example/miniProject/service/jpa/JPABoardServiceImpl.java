package com.example.miniProject.service.jpa;

import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.repository.jpa.JPABoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JPABoardServiceImpl implements JPABoardService {

    @Autowired
    private JPABoardRepository boardRepository;

    @Override
    public void register(Board board) throws Exception {
        boardRepository.create(board);
    }

    @Override
    public List<Board> list() throws Exception {
        return  boardRepository.list();
    }

    @Override
    public Board read(Long boardNo) throws Exception {
        return boardRepository.read(boardNo);
    }

    @Override
    public void remove(Long boardNo) throws Exception {
        boardRepository.delete(boardNo);
    }

    @Override
    public void modify(Board board) throws Exception {
        boardRepository.update(board);
    }
}
