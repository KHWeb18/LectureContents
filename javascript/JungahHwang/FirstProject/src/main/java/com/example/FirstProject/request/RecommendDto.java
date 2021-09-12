package com.example.FirstProject.request;

import com.example.FirstProject.entity.Recommend;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendDto {
    private Long boardNo;
    private String id;
    private String title;
    private String content;
    private String img;
    private String x;
    private String y;
    private String placeName;
    private String address;
    private String phone;
    private String url;
    private Date regDate;
    private Date updDate;

    public Recommend toEntity() {
        return Recommend.builder()
                .boardNo(boardNo)
                .id(id)
                .title(title)
                .content(content)
                .img(img)
                .x(x)
                .y(y)
                .placeName(placeName)
                .address(address)
                .phone(phone)
                .url(url)
                .regDate(regDate)
                .updDate(updDate)
                .build();
    }
}
