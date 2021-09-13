package com.example.projectTest.repository;

import com.example.projectTest.entity.Account;
import com.example.projectTest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaBookRepository extends JpaRepository<Book, Long> {
    
}