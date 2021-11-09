package com.example.springTest.repository;

import com.example.springTest.entity.RandNumMessage;
import org.springframework.stereotype.Repository;

@Repository
public class RandNumRepository {

    public RandNumMessage getRandom() {
        return new RandNumMessage();
    }
}

