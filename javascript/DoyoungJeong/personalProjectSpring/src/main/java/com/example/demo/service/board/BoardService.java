package com.example.demo.service.board;

import com.example.demo.controller.board.request.BoardRequest;
import com.example.demo.controller.board.request.ReplyModifyRequest;
import com.example.demo.controller.board.request.ReplyRequest;
import com.example.demo.entity.board.Board;
import com.example.demo.entity.board.BoardReply;

import java.util.List;

public interface BoardService {

    public void upload(BoardRequest boardRequest) throws Exception;

    public List<Board> list() throws Exception;

    public Board read(Integer boardNo) throws Exception;

    public void delete(Integer boardNo) throws Exception;

    public void modify(BoardRequest boardRequest) throws Exception;

    public void addReply(ReplyRequest replyRequest) throws Exception;

    public List<BoardReply> replyList(Integer boardNo) throws Exception;

    public void deleteReply(Integer replyNo) throws Exception;

    public void modifyReply(ReplyModifyRequest replyModifyRequest) throws Exception;

}
