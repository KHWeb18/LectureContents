//package com.example.miniProject.controller.reservaion;
//
//import com.example.miniProject.controller.reservaion.request.ReservationRequest;
//import com.example.miniProject.entity.jpa.Board;
//import com.example.miniProject.entity.jpa.Room;
//import com.example.miniProject.service.jpa.JPARoomService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@Controller
//@RequestMapping("/room")
//@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
//public class RoomController {
//
//    @Autowired
//    private JPARoomService roomService;
//
//
//
//    @PostMapping("/book")
//    public ResponseEntity<Void> booking(@Validated @RequestBody Room room) throws Exception {
//        log.info("roomId: " + room.getRoomId() + "personNum: " + room.getPersonNum() + "bankName: " + room.getBankName()
//                + "price: " + room.getPrice() + "period: " + room.getPeriod()+ "roomCnt: " + room.getRoomCnt());
//
//        if(room.getRoomId() != null) {
//                    roomService.bookRoom(room);
//                    // 날짜마다 한개씩 방이 있어야하는데 예약이 되면 1
//                    room.setRoomCnt(1);
//        }
//
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }
//
//    // 달력과 관련하여 날짜별 방 예약상태가 나타날때
//    // roomCnt가 1이면 예약 불가능
//}
//
//
