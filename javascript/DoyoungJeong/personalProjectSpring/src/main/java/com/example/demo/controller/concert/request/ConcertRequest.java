package com.example.demo.controller.concert.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ConcertRequest {

    private Integer[] likedNums;
    private Long memberNo;
    private Long concertNo;
    private String concertName;
    private String concertArtist;
    private String concertVenue;
    private String concertPrice;
    private String concertDate;
    private String concertInfo;
}
