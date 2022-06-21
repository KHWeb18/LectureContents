package com.example.miniProject.controller.reservaion.request;

import com.example.miniProject.entity.jpa.Room;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class DateRequest {
    private String reservedDate;
}
