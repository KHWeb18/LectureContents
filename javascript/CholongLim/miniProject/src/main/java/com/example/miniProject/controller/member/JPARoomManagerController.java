package com.example.miniProject.controller.member;


import com.example.miniProject.controller.member.request.UserRequest;
import com.example.miniProject.controller.reservaion.request.RoomRequest;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.entity.jpa.MemberAuth;
import com.example.miniProject.entity.jpa.Reservation;
import com.example.miniProject.entity.jpa.Room;
import com.example.miniProject.service.jpa.JPAMemberManagerService;
import com.example.miniProject.service.jpa.JPARoomManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/roomManage")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPARoomManagerController {

    @Autowired
    private JPARoomManagerService roomManagerService;


    @GetMapping("/lists")
    public ResponseEntity<List<Room>> getLists () throws Exception {
        log.info("getLists(): " + roomManagerService.list());

        return new ResponseEntity<>(roomManagerService.list(), HttpStatus.OK);
    }

    @GetMapping("/reservationLists")
    public ResponseEntity<List<Reservation>> getReservationLists () throws Exception {
        log.info("getReservationLists(): " + roomManagerService.bookList());

        return new ResponseEntity<>(roomManagerService.bookList(), HttpStatus.OK);
    }

    @GetMapping("/{bookNo}")
    public ResponseEntity<Room> read(@PathVariable("bookNo") Long bookNo) throws Exception {
        Room room = roomManagerService.read(bookNo);

        return new ResponseEntity<Room>(room, HttpStatus.OK);
    }


    @DeleteMapping("/{bookNo}")
    public ResponseEntity<Void> remove(@PathVariable("bookNo") Long bookNo) throws Exception {
        roomManagerService.remove(bookNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}



