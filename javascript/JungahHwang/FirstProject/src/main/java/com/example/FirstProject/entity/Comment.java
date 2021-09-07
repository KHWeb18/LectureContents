package com.example.FirstProject.entity;

import com.example.FirstProject.request.CommentDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "comment_no")
    private Long commentNo;

    @Column(length = 50, nullable = false)
    private String id;

    @Column(length = 300, nullable = false)
    private String content;

    @Column(nullable = false)
    private Long boardNo;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public void updateContent(CommentDto commentDto) {
        this.content = commentDto.getContent();
    }

}
