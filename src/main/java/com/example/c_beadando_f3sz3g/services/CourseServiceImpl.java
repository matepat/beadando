package com.example.c_beadando_f3sz3g.services;

import com.example.c_beadando_f3sz3g.entities.Course;
import com.example.c_beadando_f3sz3g.entities.Room;
import com.example.c_beadando_f3sz3g.entities_form.CourseForm;
import com.example.c_beadando_f3sz3g.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    private RoomService roomService;
    @Autowired
    public void setRoomService(RoomService roomService) {this.roomService = roomService;}

    @Override
    public List<Course> listAll() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    @Override
    public Course getById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course saveOrUpdate(Course course) {
        courseRepository.save(course);
        return course;
    }

    @Override
    public void delete(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> listAllByRoom(Room room){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAllByRoom(room).forEach(courses::add);
        return courses;
    }

    @Override
    public Course CourseFormToCourse(CourseForm courseForm){
        Course course = new Course();
        course.setId(courseForm.getId());
        course.setName(courseForm.getName());
        course.setRoom(roomService.getById(courseForm.getRoomId()));
        return course;
    }
}
