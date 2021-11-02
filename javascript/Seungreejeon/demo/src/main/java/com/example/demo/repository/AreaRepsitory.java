package com.example.demo.repository;


import org.springframework.stereotype.Repository;

@Repository
public class AreaRepsitory {

    public float calc(Integer height, Integer width) throws Exception {
        float area = (float) (height * width) / 2;

        return area;
    }
}
