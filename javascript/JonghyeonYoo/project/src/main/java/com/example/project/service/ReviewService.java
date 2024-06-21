package com.example.project.service;


import com.example.project.entity.Board;
import com.example.project.entity.Review;

import java.util.List;

public interface ReviewService {
     void register(Review review) throws Exception;

     List<Review> list() throws Exception;

     Review read(Integer reviewNo) throws Exception;

     void remove(Integer reviewNo) throws Exception;

     void modify(Review review) throws Exception;
}