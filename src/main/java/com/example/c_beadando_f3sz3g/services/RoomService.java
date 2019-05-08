package com.example.c_beadando_f3sz3g.services;

import com.example.c_beadando_f3sz3g.entities.Room;

import java.util.List;

public interface RoomService {
    List<Room> listAll();
    Room getById(int id);
    Room saveOrUpdate(Room room);
    void delete(int id);
}
