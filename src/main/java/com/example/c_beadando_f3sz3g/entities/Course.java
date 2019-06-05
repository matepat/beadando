package com.example.c_beadando_f3sz3g.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @ManyToOne
    Room room;
}
