package com.example.demo.repository.board;

import com.example.demo.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    //@Query(value = "select * from board where board_no > 0 order by board_no asc", nativeQuery = true)
    //밑 처럼 말고 위에처럼밖에 실행 안됐던 이유??? --> 엔티티에 오타있었음.. boardNo이 boardContentNo로 적혀있어서 계속 에러났었다..
    @Query("select bo from Board bo where bo.boardNo > 0 order by boardNo asc")
    List<Board> getList();

    @Query("select bo from Board bo where bo.boardNo = :boardNo")
    Board getRead(Long boardNo);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Board bo where bo.boardNo = :boardNo")
    void delete(Long boardNo);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Board bo set bo.title = :title, bo.content = :content where bo.boardNo = :boardNo")
    void modify(String title, String content, Long boardNo);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Board bo set bo.id = '탈퇴한 회원' where bo.id = :id") //탈퇴한 회원이 작성한 보드의 id 바꿔줌.
    void makeIdAsWithdrawn(String id);
}
