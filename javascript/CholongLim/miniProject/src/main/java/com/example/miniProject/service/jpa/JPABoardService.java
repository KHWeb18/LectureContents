package com.example.miniProject.service.jpa;

import com.example.miniProject.entity.jpa.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface JPABoardService {
    public void register(Board board) throws Exception;

    public Board read(Long boardNo) throws Exception;

    public void remove(Long boardNo) throws Exception;

    public List<Board> list() throws Exception;

}