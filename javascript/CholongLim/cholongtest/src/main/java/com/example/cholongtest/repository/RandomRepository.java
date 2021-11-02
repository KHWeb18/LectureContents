package com.example.cholongtest.repository;

import com.example.cholongtest.entity.RandNumMessage;
import org.springframework.stereotype.Repository;

@Repository
public class RandomRepository {

    public RandNumMessage getRandom() {
        return new RandNumMessage();
    }
}
