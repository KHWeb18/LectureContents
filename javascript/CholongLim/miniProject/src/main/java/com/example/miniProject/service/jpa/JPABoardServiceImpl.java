package com.example.miniProject.service.jpa;


import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.repository.jpa.JPABoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


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



    @Transactional
    public void modify(Board board) throws Exception {
        Optional<Board> Update= boardRepository.updateBoard(board.getBoardNo(),board.getTitle(),board.getContent());


        if(Update.isPresent()) {
            Board input = Update.get();
            log.info("null = x");
        } else {
            log.info("null = o");
        }


    }

}

