package com.example.FirstProject.request;

import com.example.FirstProject.entity.Record;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordDto {
    private Long recordNo;
    private String id;
    private String date;
    private String food;
    private String exercise;
    private Long weight;
    private Date regDate;
    private Date updDate;

    public Record toEntity () {
        return Record.builder()
                .recordNo(recordNo)
                .id(id)
                .date(date)
                .food(food)
                .exercise(exercise)
                .weight(weight)
                .regDate(regDate)
                .updDate(updDate)
                .build();
    }
}
