package com.example.miniProject.service.jpa;

import com.example.miniProject.controller.reservaion.request.ReservationRequest;
import com.example.miniProject.entity.jpa.Room;

public interface JPARoomService {

    public void bookRoom(Room room) throws Exception;
}
