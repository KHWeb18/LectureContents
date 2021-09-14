package com.example.demo.controller.member.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConcertRequestResponse {

    private Long concertRequestNo;
    private String regName;
    private String artistName;
    private String venueName;
    private String concertName;
    private String dateOfConcert;
    private String timeOfConcert;
    private String approvedOrNot;
    private String requestReply;
    private String regDate;

    public ConcertRequestResponse(Long concertRequestNo, String regName, String artistName, String venueName, String concertName,
                                  String dateOfConcert, String timeOfConcert, String approvedOrNot, String requestReply, String regDate) {

        this.concertRequestNo = concertRequestNo;
        this.regName = regName;
        this.artistName = artistName;
        this.venueName = venueName;
        this.concertName = concertName;
        this.dateOfConcert = dateOfConcert;
        this.timeOfConcert = timeOfConcert;
        this.approvedOrNot = approvedOrNot;
        this.requestReply = requestReply;
        this.regDate = regDate;
    }
}
