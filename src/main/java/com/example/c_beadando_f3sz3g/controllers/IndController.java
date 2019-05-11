package com.example.c_beadando_f3sz3g.controllers;

import com.example.c_beadando_f3sz3g.entities.Course;
import com.example.c_beadando_f3sz3g.entities.Room;
import com.example.c_beadando_f3sz3g.services.CourseService;
import com.example.c_beadando_f3sz3g.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class IndController {

    private CourseService courseService;
    private RoomService roomService;

    @Autowired
    public void setCourseService(CourseService courseService) {this.courseService = courseService;}
    @Autowired
    public void setRoomService(RoomService roomService) {this.roomService = roomService;}

    @RequestMapping("/")
    public String getIndex(Model model){
        model.addAttribute("courses", courseService.listAll());
        model.addAttribute("rooms", roomService.listAll());
        return "index";
    }
}
