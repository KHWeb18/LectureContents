package com.example.demo.controller.member.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@ToString
public class ArtistAuthRequest {
    
    //공연 등록 요청용 엔티티
    private Integer concertRequestNo;
    private Integer memberNo;
    private String regName;
    private String artistName;
    private String venueName;
    private String concertName;
    private Date dateOfConcert;
    private String timeOfConcert;
    private String timeOfEnd;
}
