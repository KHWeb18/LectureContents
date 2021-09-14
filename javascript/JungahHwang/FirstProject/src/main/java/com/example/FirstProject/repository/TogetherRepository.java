package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Together;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TogetherRepository extends JpaRepository<Together, Long> {

    @Query("select t from Together t where t.id like :id")
    List<Together> userRead(@Param("id") String id);

}
