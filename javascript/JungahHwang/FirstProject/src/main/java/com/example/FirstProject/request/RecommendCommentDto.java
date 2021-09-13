package com.example.FirstProject.request;

import com.example.FirstProject.entity.RecommendComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendCommentDto {
    private Long commentNo;
    private String id;
    private String content;
    private Long boardNo;
    private Date regDate;
    private Date updDate;

    public RecommendComment toEntity() {
        return RecommendComment.builder()
                .commentNo(commentNo)
                .id(id)
                .content(content)
                .boardNo(boardNo)
                .regDate(regDate)
                .updDate(updDate)
                .build();
    }

}
