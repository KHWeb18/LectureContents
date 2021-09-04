package com.example.miniProject.service.jpa;


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
public class JPARoomManagerServiceImpl implements JPARoomManagerService {

    @Autowired
    private JPARoomRepository roomRepository;

    @Autowired
    private JPAReservationRepository reservationRepository;

    @Override
    public List<Room> list() throws Exception {
        return roomRepository.findAll();
    }

    @Override
    public void remove(Long bookNo) throws Exception {
        roomRepository.deleteById(bookNo);
    }

    @Override
    public Room read(Long bookNo) throws Exception {
        Optional<Room> memberDetail = roomRepository.findById(bookNo);
        if(memberDetail.isPresent()) {
            Room room = memberDetail.get();
            roomRepository.save(room);

            return room;
        } else {
            throw new NullPointerException();
        }

    }

    //reservationDate
    public List<Reservation> bookList( ) throws Exception {
        return reservationRepository.findAll();
    }



}
