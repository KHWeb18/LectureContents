package com.example.FirstProject.request;

import com.example.FirstProject.entity.TogetherComment;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TogetherCommentDto {
    private Long commentNo;
    private String id;
    private String content;
    private Long boardNo;
    private Date regDate;
    private Date updDate;

    public TogetherComment toEntity() {
        return TogetherComment.builder()
                .commentNo(commentNo)
                .id(id)
                .content(content)
                .boardNo(boardNo)
                .regDate(regDate)
                .updDate(updDate)
                .build();
    }

}
