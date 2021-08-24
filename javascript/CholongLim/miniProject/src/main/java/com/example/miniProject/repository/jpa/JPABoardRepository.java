package com.example.miniProject.repository.jpa;

import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.entity.jpa.BoardDto;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.entity.jpa.TestMember;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public interface JPABoardRepository extends JpaRepository<Board, Long> {

    // 게시판 검색기능 (제목)
//    @Query("select b from Board b where b.title like '%:title%' or b.content like %:content%")
//    Optional<Board> findByTitle(String title);

    List<Board> findByTitleContaining(String keyword);
}


