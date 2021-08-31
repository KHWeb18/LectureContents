package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecommendJPARepository extends JpaRepository<Recommend, Long> {

    @Query("select r.boardNo, r.id, r.title, substring(r.content, 1, 90), " +
            "date_format(r.regDate, '%Y.%m.%d') from Recommend r")
    List<Object[]> lists();

    @Query("select r.boardNo, r.id, r.title, r.content, date_format(r.regDate, '%Y.%m.%d / %T') " +
            "from Recommend r where r.boardNo like :boardNo")
    List<Object[]> read(@Param("boardNo") Long boardNo);


}
