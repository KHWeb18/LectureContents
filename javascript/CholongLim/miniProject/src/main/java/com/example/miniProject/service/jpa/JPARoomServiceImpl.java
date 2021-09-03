package com.example.miniProject.service.jpa;

import com.example.miniProject.controller.reservaion.request.RoomRequest;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.entity.jpa.Reservation;
import com.example.miniProject.entity.jpa.Room;
import com.example.miniProject.repository.jpa.JPAReservationRepository;
import com.example.miniProject.repository.jpa.JPARoomRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JPARoomServiceImpl implements JPARoomService {

    @Autowired
    private JPARoomRepository roomRepository;

    @Autowired
    private JPAReservationRepository reservationRepository;

    @Override
    public void bookRoom(RoomRequest roomRequest) throws Exception {

        Reservation bookEntity = new Reservation(roomRequest.getReservedDate());
        Room roomEntity = new Room(roomRequest.getRoomId(), roomRequest.getPeriod(), roomRequest.getPersonNum(),
                roomRequest.getBankName(), roomRequest.getPrice(), roomRequest.getUserId(), roomRequest.getRoomCnt(), roomRequest.getRegDate());
        roomEntity.addDate(bookEntity);

        roomRepository.save(roomEntity);
    }

    // 수정전
//    @Override
//    public boolean checkRoom(RoomRequest roomRequest) throws Exception {
//        Optional<Room> already = roomRepository.findByRoomId(roomRequest.getRoomId());
//        Optional<Reservation> bookDate = reservationRepository.findByRoomId(roomRequest.getReservedDate());
//
//        if(!already.isPresent()){
//            log.info("what is " + roomRepository.findByRoomId(roomRequest.getRoomId()));
//            return true;
//        }
//
//        Room checkDate = already.get();
//        Reservation dates = bookDate.get();
//
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String inputDate = format.format(roomRequest.getReservedDate());
//
//
//        if (roomRequest.getRoomId().equals(checkDate.getRoomId())) {
//            log.info("same room number");
//            if(roomRequest.getReservedDate().equals(dates.getReservedDate())) {
//                log.info("room already reserved");
//                return false;
//            }  else {
//                log.info("You can reserved");
//                return true;
//
//            }
//
//        }
//        return true;
//    }


    @Override
    public boolean checkRoom(RoomRequest roomRequest) throws Exception {
        List<Room> already = roomRepository.findByRoomId(roomRequest.getRoomId());
        List<Reservation> bookDate = reservationRepository.findByDate(roomRequest.getReservedDate());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String inputDate = format.format(roomRequest.getReservedDate());
        inputDate = format.format(new Date());
        Date date = format.parse(inputDate);


        if (already.isEmpty()) {
            log.info("room is empty : " + roomRepository.findByRoomId(roomRequest.getRoomId()));
            return true;
        }
        for (Room room : already) {
            if (room.getRoomId().equals(roomRequest.getRoomId())) {
                log.info("same roomId" + room.getRoomId() + " : " + roomRequest.getRoomId());
                for (Reservation reservation : bookDate) {
                    log.info("reservation.getReservedDate() : " + reservation.getReservedDate() + ", " + "date : " + date );
                    if (reservation.getReservedDate().compareTo(date) != 0) {
                        log.info("same reserveDate" + reservation.getReservedDate() + " : " + inputDate);
                        log.info("u can't reserve");
                        return false;
                    }
                }
            } else {
                log.info("u can reserve");
                return true;
            }
        }

        return true;
    }



//
//        log.info("11111111 roomRequest.getRoomId()? " + roomRequest.getRoomId());
//        log.info("22222222 inputDate? " + inputDate);
//
//        log.info("3333 already? " + already);
//        log.info("4444 bookDate? " + bookDate);


//        if (room.getRoomId()) {
//            log.info("same roomId");
//            if (bookDate.indexOf(inputDate) != -1) {
//                log.info("same date, you can't reserve");
//                return false;
//            }
//        } else {
//            log.info("You can reserved");
//            return true;
//        }
//        return true;
//    }


//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String inputDate = format.format(roomRequest.getReservedDate());



    // 수정 전 하나의 내역만 볼 수 있음
//    @Override
//    public Room bookList(String userId) throws Exception {
//        Optional<Room> bookInfo =  roomRepository.findByUserInfo(userId);
//        log.info("reservation list :" + roomRepository.findByUserInfo(userId) );
//        if(!bookInfo.isPresent()){
//            throw new IllegalStateException();
//        }
//        return bookInfo.get();
//    }

    // 수정 후 여러 내역을 볼 수있음
    @Override
    public List<RoomRequest> bookList(String userId) throws Exception {
        List<Room> rooms =  roomRepository.findByUserIdContaining(userId);
        List<RoomRequest> roomsList = new ArrayList<>();

        if(rooms.isEmpty()) return roomsList;

        for(Room room : rooms) {
            roomsList.add(this.convertEntityToRequest(room));
        }
        return roomsList;
    }

    private RoomRequest convertEntityToRequest(Room room) {
        return RoomRequest.builder()
                .bookNo(room.getBookNo())
                .personNum(room.getPersonNum())
                .bankName(room.getBankName())
                .roomId(room.getRoomId())
                .price(room.getPrice())
                .regDate(room.getRegDate())
                .build();
    }

    @Override
    public Room read(Long bookNo) throws Exception {
        Optional<Room> bookDetail = roomRepository.findById(bookNo);
        if(bookDetail.isPresent()) {
            Room room = bookDetail.get();
            roomRepository.save(room);

            return room;
        } else {
            throw new NullPointerException();
        }

    }

    @Override
    public void remove(Long bookNo) throws Exception {
        roomRepository.deleteById(bookNo);
    }




}
