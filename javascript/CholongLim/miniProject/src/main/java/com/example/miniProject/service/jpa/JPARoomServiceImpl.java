package com.example.miniProject.service.jpa;

import com.example.miniProject.controller.reservaion.request.RoomRequest;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.entity.jpa.Reservation;
import com.example.miniProject.entity.jpa.Room;
import com.example.miniProject.repository.jpa.JPAReservationRepository;
import com.example.miniProject.repository.jpa.JPARoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JPARoomServiceImpl implements JPARoomService{

    @Autowired
    private JPARoomRepository roomRepository;

    @Autowired
    private JPAReservationRepository reservationRepository;

    @Override
    public void bookRoom(RoomRequest roomRequest) throws Exception{

        Reservation bookEntity = new Reservation(roomRequest.getReservedDate());
        Room roomEntity = new Room(roomRequest.getRoomId(),roomRequest.getPeriod(),roomRequest.getPersonNum(),
                roomRequest.getBankName(),roomRequest.getPrice(),roomRequest.getUserId(),roomRequest.getRoomCnt());
        roomEntity.addDate(bookEntity);

        roomRepository.save(roomEntity);
    }


    @Override
    public boolean checkRoom(RoomRequest roomRequest) throws Exception {
        log.info("what is " + roomRepository.findByRoomId(roomRequest.getRoomId()));
        Optional<Room> already = roomRepository.findByRoomId(roomRequest.getRoomId());

        if(!already.isPresent()){
            log.info("what is " + roomRepository.findByRoomId(roomRequest.getRoomId()));
            return true;
        }

        Room checkDate = already.get();
        List dates = checkDate.getDateList();
        List list = dates;


        log.info("date" + dates);



//        String result;
//        for( Object reservation : list) {
//            result += reservation;
//        }

        if (roomRequest.getRoomId().equals(checkDate.getRoomId())) {
             log.info("umm,ok~ same room number");
            if(roomRequest.getReservedDate().equals(dates)) {
                log.info("room already reserved");
                return false;
            }  else {
                log.info("You can reserved");
                return true;

            }

        }
        return true;
    }

    @Override
    public Room bookList(String userId) throws Exception {
        Optional<Room> bookInfo =  roomRepository.findByUserInfo(userId);
        log.info("reservation list :" + roomRepository.findByUserInfo(userId) );
        if(!bookInfo.isPresent()){
            throw new IllegalStateException();
        }
        return bookInfo.get();
    }

    @Override
    public void remove(Long bookNo) throws Exception {
        roomRepository.deleteById(bookNo);
    }




}
