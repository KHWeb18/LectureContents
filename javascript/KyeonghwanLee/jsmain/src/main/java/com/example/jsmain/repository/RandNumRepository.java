package com.example.jsmain.repository;

import com.example.jsmain.entity.RandNumMessage;
import org.springframework.stereotype.Repository;

@Repository
public class RandNumRepository {

    public RandNumMessage getRandom() {
        return new RandNumMessage();
    }
}