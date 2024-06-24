package com.example.demo.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
// JPA 사용시 필수적인 Annotation이 Entity
@Entity
@Getter
@Setter
@ToString
public class VueMember {
    // @id @generatedValue @column은 db를 자동으로 만드는 것. 그중 id는 고유한 값

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberNo;

    // 길이가 20개 null 이 되면 안된다.
    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private String pw;

    @CreationTimestamp
    private LocalDateTime createdDate;

    //해킹 등을 당했을 때 바지막으로 바뀐날
    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;
}
