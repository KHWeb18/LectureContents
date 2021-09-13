package com.example.demo.service.concert;

import com.example.demo.controller.concert.request.BookingRequest;
import com.example.demo.controller.concert.response.BookedConcertResponse;
import com.example.demo.entity.concert.Concert;
import com.example.demo.entity.member.BookedConcert;
import com.example.demo.entity.member.LikedConcert;

import java.util.List;
import java.util.Optional;

public interface ConcertService {

    public Optional<Concert> findByConcertNo(Long concertNo);

    public List<LikedConcert> getLikedList(Long memberNo);

    public void makeBooking(BookedConcert bookedConcert);

    public boolean isNotAlreadyBooked(Long memberNo, Long concertNo);

    public List<BookedConcertResponse> getBookedConcertList(Long memberNo);

    public BookedConcertResponse getBookedConcert(Long memberNo);

    public void alterBooking(BookedConcert bookedConcert);

    public void deleteBooking(Integer bookedConcertNo);
}
