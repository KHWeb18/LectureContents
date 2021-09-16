package com.example.project.controller.vue;

import com.example.project.entity.Board;
import com.example.project.entity.Review;
import com.example.project.service.ReviewService;
import com.example.project.service.VueBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping("/register")
    public ResponseEntity<Review> register(@Validated @RequestBody Review review) throws Exception {
        log.info("post register request from vue");

        service.register(review);

        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Review>> getLists () throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{reviewNo}")
    public ResponseEntity<Review> read(@PathVariable("reviewNo") Integer reviewNo) throws Exception{
        Review review = service.read(reviewNo);

        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }

    @PutMapping("/{reviewNo}")
    public ResponseEntity<Review> modify(@PathVariable("reviewNo") Integer reviewNo,
                                        @Validated @RequestBody Review review) throws Exception {
        review.setReviewNo(reviewNo);
        service.modify(review);

        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @DeleteMapping("/{reviewNo}")
    public ResponseEntity<Void> remove(@PathVariable("reviewNo") Integer reviewNo) throws Exception {
        service.remove(reviewNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}