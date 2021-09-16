package com.example.miniProject.service.jpa;


import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.repository.jpa.JPABoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

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

//    @Override
//    public List<Board> list(String title, String content) throws Exception {
////        if(StringUtils.isEmpty(title) && StringUtils.isEmpty(content)) {
////            return boardRepository.findAll();
////        } else {
//            return boardRepository.findByTitleContainingOrContentContaining(title,content);
////        }
//
////        return boardRepository.findAll();
//    }

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

}

