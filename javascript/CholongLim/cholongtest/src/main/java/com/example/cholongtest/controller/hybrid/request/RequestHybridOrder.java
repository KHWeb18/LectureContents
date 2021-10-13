package com.example.cholongtest.controller.hybrid.request;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestHybridOrder {

    private String name;
    private Integer cost;
}
