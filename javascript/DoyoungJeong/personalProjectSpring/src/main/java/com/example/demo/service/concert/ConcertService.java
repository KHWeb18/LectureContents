package com.example.demo.service.concert;

import com.example.demo.entity.concert.Concert;
import com.example.demo.entity.member.LikedConcert;

import java.util.List;
import java.util.Optional;

public interface ConcertService {

    public Optional<Concert> findByConcertNo(Long concertNo);

    public List<LikedConcert> getLikedList(Long memberNo);

}
