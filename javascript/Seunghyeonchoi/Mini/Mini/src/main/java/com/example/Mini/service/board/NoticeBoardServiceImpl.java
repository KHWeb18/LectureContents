package com.example.Mini.service.board;

import com.example.Mini.entity.board.Notice;
import com.example.Mini.repository.board.NoticeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시한다.
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {

    @Autowired
    private NoticeBoardRepository repository;

    @Override
    public void register(Notice board) throws Exception {
        repository.create(board);
    }

    @Override
    public List<Notice> list() throws Exception {
        return repository.list();
    }

    @Override
    public Notice read(Integer boardNo) throws Exception {
        return repository.read(boardNo);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        repository.delete(boardNo);
    }

    @Override
    public void modify(Notice board) throws Exception {
        repository.update(board);
    }
}