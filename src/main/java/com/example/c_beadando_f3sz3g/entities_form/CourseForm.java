package com.example.c_beadando_f3sz3g.entities_form;

import com.example.c_beadando_f3sz3g.entities.Course;
import com.example.c_beadando_f3sz3g.services.RoomService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class CourseForm {
    int id;
    String name;
    int roomId;

    /*private RoomService roomService;
    @Autowired
    public void setRoomService(RoomService roomService) {this.roomService = roomService;}*/

    public CourseForm(Course course){
        id = course.getId();
        name = course.getName();
        roomId = course.getRoom().getId();
    }

    public CourseForm(){

    }

    /*public Course CourseFormToCourse(){
        Course course = new Course();
        course.setId(id);
        course.setName(name);
        course.setRoom(roomService.getById(roomId));
        return course;
    }*/
}
