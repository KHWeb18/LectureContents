package com.example.cholongtest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@Getter
public class RandNumMessage {

    private static Random random = new Random();

    private Integer randNumber;

    public  RandNumMessage () {
        this.randNumber = random.nextInt(32) + 3;

        log.info("RandomMessage(): " + randNumber);
    }
}
