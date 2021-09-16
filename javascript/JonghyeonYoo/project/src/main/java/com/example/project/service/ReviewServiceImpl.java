package com.example.project.service;

import com.example.project.entity.Board;
import com.example.project.entity.Review;
import com.example.project.repository.ReviewRepository;
import com.example.project.repository.VueBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시한다.
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Override
    public void register(Review review) throws Exception {
        repository.create(review);
    }

    @Override
    public List<Review> list() throws Exception {
        return repository.list();
    }

    @Override
    public Review read(Integer reviewNo) throws Exception {
        return repository.read(reviewNo);
    }

    @Override
    public void remove(Integer reviewNo) throws Exception {
        repository.delete(reviewNo);
    }

    @Override
    public void modify(Review review) throws Exception {
        repository.update(review);
    }
}