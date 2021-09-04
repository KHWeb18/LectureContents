package com.example.miniProject.service.jpa;


import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.entity.jpa.Reservation;
import com.example.miniProject.entity.jpa.Room;

import java.util.List;

public interface JPARoomManagerService {


    public List<Room> list( ) throws Exception;

    public void remove(Long bookNo) throws Exception;

    public Room read(Long bookNo) throws Exception;

    // date
    public List<Reservation> bookList( ) throws Exception;

}