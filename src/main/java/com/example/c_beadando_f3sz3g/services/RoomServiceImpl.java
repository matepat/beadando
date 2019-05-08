package com.example.c_beadando_f3sz3g.services;

import com.example.c_beadando_f3sz3g.entities.Room;
import com.example.c_beadando_f3sz3g.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    private RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> listAll() {
        List<Room> rooms = new ArrayList<>();
        roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    @Override
    public Room getById(int id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Room saveOrUpdate(Room room) {
        roomRepository.save(room);
        return room;
    }

    @Override
    public void delete(int id) {
        roomRepository.deleteById(id);
    }

}
