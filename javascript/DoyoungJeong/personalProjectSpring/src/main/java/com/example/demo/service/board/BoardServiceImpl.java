package com.example.demo.service.board;

import com.example.demo.controller.board.request.BoardRequest;
import com.example.demo.controller.board.request.ReplyModifyRequest;
import com.example.demo.controller.board.request.ReplyRequest;
import com.example.demo.entity.board.Board;
import com.example.demo.entity.board.BoardReply;
import com.example.demo.repository.board.BoardReplyRepository;
import com.example.demo.repository.board.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardReplyRepository boardReplyRepository;

    @Override
    public void upload(BoardRequest boardRequest) throws Exception {

        Board board = new Board(boardRequest.getId(), boardRequest.getTitle(), boardRequest.getContent());

//        BoardReply boardReply = new BoardReply("default", "default"); //해줄 필요 없음
//        board.addBoardReply(boardReply);
        boardRepository.save(board);
    }

    @Override
    public List<Board> list() throws Exception {
        return boardRepository.getList();
    }

    @Override
    public Board read(Integer boardNo) throws Exception {
        return boardRepository.getRead(new Long(boardNo));
    }

    @Override
    public void delete(Integer boardNo) throws Exception {
        boardReplyRepository.delete(new Long(boardNo));
        boardRepository.delete(new Long(boardNo));
    }

    @Override
    public void modify(BoardRequest boardRequest) throws Exception {

        String title = boardRequest.getTitle();
        String content = boardRequest.getContent();
        Long boardNo = new Long(boardRequest.getBoardNo());

        boardRepository.modify(title, content, boardNo);
    }

    @Override
    public void addReply(ReplyRequest replyRequest) throws Exception {

        String id = replyRequest.getId();
        String content = replyRequest.getContent();
        Long boardNo = new Long(replyRequest.getBoardNo());

        BoardReply boardReply =  new BoardReply(id, content);
        boardReply.setBoardNo(boardNo);

        boardReplyRepository.save(boardReply);
    }

    @Override
    public List<BoardReply> replyList(Integer boardNo) throws Exception {

        return boardReplyRepository.getReplyList(new Long(boardNo));
    }

    @Override
    public void deleteReply(Integer replyNo) throws Exception {
        boardReplyRepository.deleteReply(new Long(replyNo));
    }

    @Override
    public void modifyReply(ReplyModifyRequest replyModifyRequest) throws Exception {

        String content = replyModifyRequest.getContent();
        Long boardReplyNo = new Long(replyModifyRequest.getReplyNo());

        boardReplyRepository.modifyReply(content, boardReplyNo);
    }
}

