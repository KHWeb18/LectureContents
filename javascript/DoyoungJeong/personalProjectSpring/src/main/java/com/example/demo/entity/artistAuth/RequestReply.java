package com.example.demo.entity.artistAuth;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="request_reply")
public class RequestReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_reply_no")
    private Long requestReplyNo;

    @Column(name = "concert_request_no")
    private Long concertRequestNo;

    @Column(length = 100, nullable = true)
    private String requestReply;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public RequestReply(String requestReply) {
        this.requestReply = requestReply;
    }
}
