package com.example.miniProject.repository.jpa;

import com.example.miniProject.entity.jpa.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface JPABoardRepository extends JpaRepository<Board, Long> {


    List<Board> findByTitleContainingOrContentContaining(String title, String content);
}


