package com.example.demo.controller.concert;

import com.example.demo.entity.Concert;
import com.example.demo.entity.member.LikedConcert;
import com.example.demo.service.concert.ConcertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/concert")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ConcertController {

    @Autowired
    private ConcertService concertService;

    @GetMapping("/{concertNo}")
    public ResponseEntity<Concert> read(@PathVariable("concertNo") Integer concertNo) throws Exception {
        log.info("concertNo: " + concertNo);

        Optional<Concert> maybeConcert = concertService.findByConcertNo(new Long(concertNo));
        Concert concert = maybeConcert.get();
        log.info("concert: " + concert);

        return new ResponseEntity<Concert>(concert, HttpStatus.OK);
    }
    
    //한 회원의 좋아요한 공연 리스트 뽑아오기
    @PutMapping("/likedList/{memberNo}")
    public ResponseEntity<List<LikedConcert>> getLikedList(@PathVariable("memberNo") Integer memberNo) throws Exception {

        log.info("memberNo: " + memberNo);

        List<LikedConcert> likedList = concertService.getLikedList(new Long(memberNo));

        log.info("likedList: " + likedList);

        return new ResponseEntity<List<LikedConcert>>(likedList, HttpStatus.OK);
    }
}
