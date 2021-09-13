package com.example.FirstProject.request;

import com.example.FirstProject.entity.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapDto {
    private Long mapNo;
    private Long boardNo;
    private String x;
    private String y;
    private String name;
    private String address;
    private String phone;
    private String url;
    private Date regDate;

    public Map toEntity() {
        return Map.builder()
                .mapNo(mapNo)
                .boardNo(boardNo)
                .x(x)
                .y(y)
                .name(name)
                .address(address)
                .phone(phone)
                .url(url)
                .regDate(regDate)
                .build();
    }
}
