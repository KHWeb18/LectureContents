package com.example.demo.repository;

import com.example.demo.entity.RandNumMessage;
import org.springframework.stereotype.Repository;

@Repository
public class RandNumRepository {
    public RandNumMessage getRandom() {
        return new RandNumMessage();
    }
}
