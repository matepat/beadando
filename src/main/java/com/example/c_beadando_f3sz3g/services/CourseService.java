package com.example.c_beadando_f3sz3g.services;

import com.example.c_beadando_f3sz3g.entities.Course;
import com.example.c_beadando_f3sz3g.entities.Room;
import com.example.c_beadando_f3sz3g.entities_form.CourseForm;

import java.util.List;

public interface CourseService {
    List<Course> listAll();
    Course getById(int id);
    Course saveOrUpdate(Course course);
    void delete(int id);
    List<Course> listAllByRoom(Room room);
    Course CourseFormToCourse(CourseForm courseForm);
}
