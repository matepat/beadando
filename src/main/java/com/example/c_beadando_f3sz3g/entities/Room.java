package com.example.c_beadando_f3sz3g.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int level;
}
