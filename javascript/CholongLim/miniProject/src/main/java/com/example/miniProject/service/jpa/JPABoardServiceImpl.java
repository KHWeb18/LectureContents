package com.example.miniProject.service.jpa;


import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.repository.jpa.JPABoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class JPABoardServiceImpl implements JPABoardService {

    @Autowired
    private JPABoardRepository boardRepository;


    @Override
    public void register(Board board) throws Exception {
        boardRepository.save(board);
    }

    @Override
    public List<Board> list() throws Exception {
        return boardRepository.findAll();
    }

    @Override
    public Board read(Long boardNo) throws Exception {
        Optional<Board> optional = boardRepository.findById(boardNo);
        if(optional.isPresent()) {
            Board board = optional.get();
            boardRepository.save(board);

            return board;
        } else {
            throw new NullPointerException();
        }

    }

    @Override
    public void remove(Long boardNo) throws Exception {
        boardRepository.deleteById(boardNo);
    }

    @Override
    public List<Board> search(String keyword) throws Exception {
       List<Board> boardList = boardRepository.findByTitleContaining(keyword);
       return boardList;
    }

}

