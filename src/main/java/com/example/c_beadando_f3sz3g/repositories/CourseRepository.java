package com.example.c_beadando_f3sz3g.repositories;

import com.example.c_beadando_f3sz3g.entities.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findAllByRoomId (int roomId);
}
