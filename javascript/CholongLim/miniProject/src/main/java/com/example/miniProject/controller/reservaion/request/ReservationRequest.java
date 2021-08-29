package com.example.miniProject.controller.reservaion.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class ReservationRequest {
//    private Date reservedDate;
    private String roomId;
    private String period;

}
