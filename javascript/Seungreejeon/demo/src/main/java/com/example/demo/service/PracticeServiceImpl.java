//package com.example.demo.service;
//
//
//import com.example.demo.entity.Board;
//import com.example.demo.repository.PracticeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class PracticeServiceImpl implements PracticeService{
//    @Autowired
//    PracticeRepository respository;
//
//    public void register(Board board) throws Exception {
//        respository.register(board);
//    }
//
//    @Override
//    public List<Board> list() throws Exception {
//        return respository.list();
//    }
//
//    @Override
//    public Board read(Integer boardNo) throws Exception {
//        return respository.read(boardNo);
//    }
//
//    @Override
//    public void modify(Board board) throws Exception{
//        respository.modify(board);
//    }
//
//    @Override
//    public void delete(Integer boardNo) throws Exception {
//        respository.delete(boardNo);
//    }
//}
