package com.example.c_beadando_f3sz3g.services;

import com.example.c_beadando_f3sz3g.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> listAll();
    Course getById(int id);
    Course saveOrUpdate(Course course);
    void delete(int id);
    List<Course> listAllByRoomId(int roomId);
}
