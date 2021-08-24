package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RecordJPARepository extends JpaRepository<Record, Long> {

    @Query("select r.food, r.exercise, r.weight from Record r where r.date like %:date%")
    List<Object[]> findByDate(@Param("date") String date);

}











