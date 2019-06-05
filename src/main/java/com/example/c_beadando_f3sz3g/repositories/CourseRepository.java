package com.example.c_beadando_f3sz3g.repositories;

import com.example.c_beadando_f3sz3g.entities.Course;
import com.example.c_beadando_f3sz3g.entities.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findAllByRoom (Room room);
}
