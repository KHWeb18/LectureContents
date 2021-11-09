package com.example.demo.repository;

import com.example.demo.entity.VueTriangle;
import org.springframework.stereotype.Repository;

@Repository
public class VueTriangleRepository {

    public int area(VueTriangle triangle) {

        Integer width = triangle.getWidthSpring();
        Integer height = triangle.getHeightSpring();

        Integer areaValue = (width * height) / 2;

        return areaValue;
    }
}
