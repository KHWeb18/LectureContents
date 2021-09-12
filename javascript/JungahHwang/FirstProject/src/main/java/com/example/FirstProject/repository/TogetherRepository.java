package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Together;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TogetherRepository extends JpaRepository<Together, Long> {

    @Query("select t.boardNo, t.id, t.title, substring(t.content, 1, 90), " +
            "date_format(t.regDate, '%Y.%m.%d') from Together t")
    List<Object[]> lists();

    @Query("select t.boardNo, t.id, t.title, t.content, date_format(t.regDate, '%Y.%m.%d %H:%i') from Together t " +
            "where t.boardNo like :boardNo")
    List<Object[]> read(@Param("boardNo") Long boardNo);

    @Query("select t from Together t where t.id like :id")
    List<Together> userRead(@Param("id") String id);

}
