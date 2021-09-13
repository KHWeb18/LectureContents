package com.example.FirstProject.entity;

import com.example.FirstProject.request.MapDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "map_no")
    private Long mapNo;

    @Column
    private Long boardNo;

    @Column
    private String x;

    @Column
    private String y;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String url;

    @CreationTimestamp
    private Date regDate;

    public void updateMap(MapDto mapDto) {
        this.mapNo = mapDto.getMapNo();
        this.boardNo = mapDto.getBoardNo();
        this.x = mapDto.getX();
        this.y = mapDto.getY();
        this.name = mapDto.getName();
        this.address = mapDto.getAddress();
        this.phone = mapDto.getPhone();
        this.url = mapDto.getUrl();
        this.regDate = mapDto.getRegDate();
    }
}
