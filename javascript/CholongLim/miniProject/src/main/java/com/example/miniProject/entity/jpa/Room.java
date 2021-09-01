package com.example.miniProject.entity.jpa;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name="room")
public class Room {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "book_no")
        private Long bookNo;

        @Column(length = 64, nullable = false)
        private String roomId;

        @Column(length = 64, nullable = false)
        private String period;

        @Column(length = 64, nullable = false)
        private String personNum;

        @Column(length = 64, nullable = false)
        private String bankName;

        @Column(length = 64, nullable = false)
        private String price;

        @Column(length = 64, nullable = false)
        private String userId;

        @Column(length = 64, nullable = false)
        private Integer roomCnt;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
        @CreationTimestamp
        private Date regDate;

        @UpdateTimestamp
        private Date updDate;


         //     조인컬럼으로 userId 가져오기 (Member) ==  예약자
        // 조인컬럼으로 받아오려 했으나 member <==> room의 공통점이 없음
        // 예약자(로그인 한 회원) --- 예약관리때문에 사용하려 했는데
        // 이럴경우 예약시 예약자(String userId 생성)에 쿠키 정보를 받고
        //  예약관리에서 그 값을 받고 Room 출력하는 방향일까요?

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        private List<Member> userList = new ArrayList<Member>();

        public Room(String roomId, String period, String personNum, String bankName, String price, Integer roomCnt ) {
        this.roomId = roomId;
        this.period = period;
        this.personNum = personNum;
        this.bankName = bankName;
        this.price = price;
        this.roomCnt = roomCnt;
        }

        public void addUserId(Member id) {
            userList.add(id);
        }

        public void clearUserList () {
            userList.clear();
        }


        //     조인컬럼으로 reservationDate 가져오기 == 예약일
        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinColumn(name = "book_no")
        private List<Reservation> dateList = new ArrayList<Reservation>();

        public void addDate(Reservation date) {
            dateList.add(date);
        }

        public void clearDateList () {
            dateList.clear();
        }

}





