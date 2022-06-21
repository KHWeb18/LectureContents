package com.example.demo.controller.concert.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConcertDeleteRequest {

    private Long memberNo;
    private Long concertNo;

}
