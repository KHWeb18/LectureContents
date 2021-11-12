package com.example.ts_backend.repository.board;

import com.example.ts_backend.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
