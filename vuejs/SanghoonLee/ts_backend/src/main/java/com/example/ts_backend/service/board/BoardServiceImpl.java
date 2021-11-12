package com.example.ts_backend.service.board;

import com.example.ts_backend.entity.board.Board;
import com.example.ts_backend.repository.board.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<Board> list() throws Exception {
        return boardRepository.findAll();
    }

    @Override
    public void register(Board board) throws Exception {
        boardRepository.save(board);
    }

    @Override
    public Board read(long boardNo) throws Exception {
        Optional<Board> maybeBoard = boardRepository.findById(boardNo);
        return maybeBoard.get();
    }

    @Override
    public void modify(Board board) throws Exception {
        boardRepository.save(board);
    }

    @Override
    public void delete(long boardNo) throws Exception {
        boardRepository.deleteById(boardNo);
    }
}
