//package com.example.miniProject.service.jpa;
//
//import com.example.miniProject.controller.reservaion.request.ReservationRequest;
//import com.example.miniProject.entity.jpa.Reservation;
//import com.example.miniProject.entity.jpa.Room;
//import com.example.miniProject.repository.jpa.JPAReservationRepository;
//import com.example.miniProject.repository.jpa.JPARoomRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Slf4j
//@Service
//public class JPAReservationServiceImpl implements JPAReservationService {
//
//    @Autowired
//    private JPAReservationRepository reservationRepository;
//
//    @Autowired
//    private JPARoomRepository roomRepository;
//
//
//    @Override
//    public void register(ReservationRequest reservationRequest) throws Exception {
//        log.info();
//        Room roomEntity = new Room(reservationRequest.getRoomId());
//        Reservation reservationEntity = new Reservation(reservationRequest.getReservedDate());
//        reservationEntity.addRoom(roomEntity);
//
//        reservationRepository.save(reservationEntity);
//
//    }
//
//
//
//}
