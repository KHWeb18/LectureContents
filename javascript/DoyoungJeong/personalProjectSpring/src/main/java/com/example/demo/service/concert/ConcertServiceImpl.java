package com.example.demo.service.concert;

import com.example.demo.controller.concert.request.ConcertRequest;
import com.example.demo.entity.Concert;
import com.example.demo.entity.member.LikedConcert;
import com.example.demo.repository.concert.ConcertRepository;
import com.example.demo.repository.member.LikedConcertRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ConcertServiceImpl implements ConcertService {

    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private LikedConcertRepository likedConcertRepository;

    @Override
    public Optional<Concert> findByConcertNo(Long concertNo) {
        return concertRepository.findByConcertNo(concertNo);
    }

    @Override
    public List<LikedConcert> getLikedList(Long memberNo) {
        return likedConcertRepository.findByMemberNo(memberNo);
    }

}
