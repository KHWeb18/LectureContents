package com.example.miniProject.service.jpa;

import com.example.miniProject.controller.reservaion.request.RoomRequest;
import com.example.miniProject.entity.jpa.Room;

import java.util.List;
import java.util.Optional;

public interface JPARoomService {

    public void bookRoom(RoomRequest roomRequest) throws Exception;

//    public Room bookList(String userId) throws Exception;
    public List<RoomRequest> bookList(String userId) throws Exception;

//    public boolean checkRoom(RoomRequest roomRequest) throws Exception;
    public boolean checkRoom(RoomRequest roomRequest) throws Exception;

    public Room read(Long bookNo) throws Exception;

    public void remove(Long bookNo) throws Exception;

}
