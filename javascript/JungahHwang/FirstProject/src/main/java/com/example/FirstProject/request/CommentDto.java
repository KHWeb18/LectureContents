package com.example.FirstProject.request;

import com.example.FirstProject.entity.Comment;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long commentNo;
    private String id;
    private String comment;
    private Long boardNo;
    private Date regDate;
    private Date updDate;

    public Comment toEntity() {
        return Comment.builder()
                .commentNo(commentNo)
                .id(id)
                .comment(comment)
                .boardNo(boardNo)
                .regDate(regDate)
                .updDate(updDate)
                .build();
    }

}
