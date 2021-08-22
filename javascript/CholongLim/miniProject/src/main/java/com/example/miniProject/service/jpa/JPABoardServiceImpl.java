package com.example.miniProject.service.jpa;


import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.entity.jpa.BoardDto;
import com.example.miniProject.repository.jpa.JPABoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class JPABoardServiceImpl implements JPABoardService {

    @Autowired
    private JPABoardRepository boardRepository;
/* Dto 이용했을때 */
    public JPABoardServiceImpl (JPABoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Long register(BoardDto boardDto) throws Exception {
        return boardRepository.save(boardDto.toEntity()).getBoardNo();
//    boardRepository.save(board);
    }

    @Override
    public List<BoardDto> list() throws Exception {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board : boards) {
            BoardDto boardDto = BoardDto.builder()
                    .boardNo(board.getBoardNo())
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .content(board.getContent())
                    .regDate(board.getRegDate())
                    .build();

            boardDtoList.add(boardDto);
        }
        return boardDtoList;
//        return boardRepository.findAll();
    }

    @Override
    public BoardDto read(Long boardNo) throws Exception {
        Optional<Board> boardWrapper = boardRepository.findById(boardNo);
        Board board = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .boardNo(board.getBoardNo())
                .title(board.getTitle())
                .writer(board.getWriter())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .build();

        return boardDto;
    }



    @Override
    public void remove(Long boardNo) throws Exception {
        boardRepository.deleteById(boardNo);
    }

//    @Override
//    public void modify(BoardDto boardDto) throws Exception {
//        boardRepository.update(boardDto.getTitle(), boardDto.getBoardNo());
//    }

//    @Override
//    public List<BoardDto> search(String keyword) throws Exception {
//        List<Board> boards = boardRepository.findByKeyword(keyword);
//        List<BoardDto> boardDtoList = new ArrayList<>();
//
//        if(boards.isEmpty()) return  boardDtoList;
//
//        for(Board board : boards) {
//            boardDtoList.add(this.convertEntityToDto(board));
//        }
//        return boardDtoList;
//    }
//
//    private BoardDto convertEntityToDto(Board board) {
//        return BoardDto.builder()
//                .boardNo(board.getBoardNo())
//                .title(board.getTitle())
//                .writer(board.getWriter())
//                .content(board.getContent())
//                .regDate(board.getRegDate())
//                .build();
//    }

}

