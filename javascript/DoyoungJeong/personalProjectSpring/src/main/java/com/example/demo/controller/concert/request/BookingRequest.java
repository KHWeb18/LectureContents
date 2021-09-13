package com.example.demo.controller.concert.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookingRequest {

    Integer memberNo;
    String name;
    String phoneNumber;
    Integer numOfVisitors;
    String message;
}
