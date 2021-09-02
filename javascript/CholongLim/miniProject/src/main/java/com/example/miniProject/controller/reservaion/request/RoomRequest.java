package com.example.miniProject.controller.reservaion.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class RoomRequest {
    private Date reservedDate;
    private Long bookNo;
    private String roomId;
    private String period;
    private String personNum;
    private String bankName;
    private String price;
    private String userId;
    private Integer roomCnt;

}
