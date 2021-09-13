package com.example.demo.controller.concert.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@ToString
public class BookedConcertResponse {

    private Long bookedConcertNo;
    private Long concertNo;
    private String name;
    private String concertName;
    private String phoneNumber;
    private Integer numOfVisitors;
    private String message;
    private String regDate;

    public BookedConcertResponse(Long bookedConcertNo, Long concertNo, String name, String concertName, String phoneNumber,
                                 Integer numOfVisitors, String message, String regDate) {
        this.bookedConcertNo = bookedConcertNo;
        this.concertNo = concertNo;
        this.name = name;
        this.concertName = concertName;
        this.phoneNumber = phoneNumber;
        this.numOfVisitors = numOfVisitors;
        this.message = message;
        this.regDate = regDate;
    }
}
