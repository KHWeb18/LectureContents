package org.example.service.repository;

import org.example.model.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel,Long> { //JpaRepository<데이터베이스와 연결된 객체, 해당객체의 아이디의 데이터타입

}
