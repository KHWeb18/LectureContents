package com.example.projectTest.service;


import com.example.projectTest.controller.request.BookForm;
import com.example.projectTest.entity.Book;
import com.example.projectTest.repository.JpaBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private JpaBookRepository bookRepository;


    @Override
    public void register(BookForm form) throws Exception {

        Book bookEntity = new Book(form.getStart(), form.getTime(), form.getTitle(), form.getName());

        bookRepository.save(bookEntity);
    }
}