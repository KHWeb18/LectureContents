package com.example.jswithspring.repository;

import com.example.jswithspring.entity.RandNumMessage;
import org.springframework.stereotype.Repository;

@Repository
public class RandNumRepository {

    public RandNumMessage getRandom() {
        return new RandNumMessage();
    }
}