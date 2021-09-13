package com.example.demo.controller.concert;

import com.example.demo.controller.concert.request.BookingRequest;
import com.example.demo.controller.concert.response.BookedConcertResponse;
import com.example.demo.controller.member.request.LikedOrNotRequest;
import com.example.demo.entity.concert.Concert;
import com.example.demo.entity.member.BookedConcert;
import com.example.demo.entity.member.LikedConcert;
import com.example.demo.service.concert.ConcertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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

    @PostMapping("/makeBooking")
    public ResponseEntity<Void> makeBooking(@Validated @RequestBody BookedConcert BookedConcert) throws Exception {
        log.info("makeBooking: " + BookedConcert);

        concertService.makeBooking(BookedConcert);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/fetchBookedOrNot")
    public ResponseEntity<Boolean> fetchBookedOrNot(@Validated @RequestBody LikedOrNotRequest likedOrNotRequest) throws Exception {

        Long memberNo = new Long(likedOrNotRequest.getLikedOrNotCheckNums()[0]);
        Long concertNo = new Long(likedOrNotRequest.getLikedOrNotCheckNums()[1]);

        boolean isNotAlreadyBooked = concertService.isNotAlreadyBooked(memberNo, concertNo);

        log.info("fetchBookedOrNot(): " + concertNo + ", " + isNotAlreadyBooked);

        return new ResponseEntity<Boolean>(isNotAlreadyBooked, HttpStatus.OK);
    }

    @GetMapping("/fetchBookedList/{memberNo}")
    public ResponseEntity<List<BookedConcertResponse>> fetchBookedList(@PathVariable("memberNo") Integer memberNo) throws Exception {
        //log.info("fetchBookedList(): " + memberNo);

        List<BookedConcertResponse> bookedConcertResponseList = concertService.getBookedConcertList(new Long(memberNo));

        return new ResponseEntity<List<BookedConcertResponse>>(bookedConcertResponseList, HttpStatus.OK);
    }

    @GetMapping("/fetchBookedConcert/{memberNo}")
    public ResponseEntity<BookedConcertResponse> fetchBookedConcert(@PathVariable("memberNo") Integer bookedConcertNo) throws Exception {
        //log.info("fetchBookedConcert(): " + memberNo);

        BookedConcertResponse bookedConcertResponse = concertService.getBookedConcert(new Long(bookedConcertNo));

        return new ResponseEntity<BookedConcertResponse>(bookedConcertResponse, HttpStatus.OK);
    }

    @PutMapping("/alterBooking")
    public ResponseEntity<Void> alterBooking(@Validated @RequestBody BookedConcert BookedConcert) throws Exception {

        concertService.alterBooking(BookedConcert);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteBooking/{bookedConcertNo}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("bookedConcertNo") Integer bookedConcertNo) throws Exception {
        //log.info("deleteBooking(): " + bookedConcertNo);

        concertService.deleteBooking(bookedConcertNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
