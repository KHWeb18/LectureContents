//package com.example.miniProject.controller.reservaion;
//
//
//import com.example.miniProject.controller.member.request.MemberRequest;
//import com.example.miniProject.controller.reservaion.request.ReservationRequest;
//import com.example.miniProject.entity.jpa.Board;
//import com.example.miniProject.entity.jpa.Member;
//import com.example.miniProject.entity.jpa.Reservation;
//import com.example.miniProject.service.jpa.JPAMemberManagerService;
//import com.example.miniProject.service.jpa.JPAReservationService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@Slf4j
//@Controller
//@RequestMapping("/book")
//@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
//public class ReservationController {
//
//    @Autowired
//    private JPAReservationService reservationService;

//    @PostMapping("/register")
//    public ResponseEntity<Void> jpaRegister(@Validated @RequestBody ReservationRequest reservationRequest,
//            HttpServletRequest request) throws Exception {
//        log.info("jpaRegister(): " + reservationRequest.getReservedDate() + ", " +
//                (reservationRequest.getRoomId().equals("301") ? "301room" :
//                        reservationRequest.getRoomId().equals("302") ? "302room" :
//                                reservationRequest.getRoomId().equals("201") ? "201room" :
//                                        reservationRequest.getRoomId().equals("202") ? "202room" : "fail"  ));
//        log.info("jpaRegister(): " + reservationRequest.getRoomId() + ", " + reservationRequest.getReservedDate());
//
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }



//}



