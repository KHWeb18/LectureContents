package com.example.demo.repository;


import com.example.demo.entity.RandNumMessage;
import org.springframework.stereotype.Repository;

@Repository
public class RandNumRespository {

    public RandNumMessage getRandom() {
        return  new RandNumMessage();
    }
}
